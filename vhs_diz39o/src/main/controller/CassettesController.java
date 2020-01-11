package cassettes;

import dao_json.DAOJSON;
import dao_json.DuplicatedCassette;
import dao_json.CassetteNotExist;

import cassettes.exceptions.ArgumentNullException;
import cassettes.exceptions.InvalidLength;
import cassettes.model.Cassette;
import cassettes.model.Genre;
import cassettes.model.Type;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CassettesController {
    @Autowired
    DAOJSON daojson;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView m = new ModelAndView("index");
        m.addObject("message");
        return m;
    }

    @RequestMapping(value = "/cassettes")
    public ModelAndView listCassettes() throws IOException {
        ModelAndView m = new ModelAndView("cassettes");
        m.addObject("cassettes", daojson.readAllCassette());
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCassette(@ModelAttribute Cassette cassette) throws IOException {
        System.out.println(cassette);
        try {
            daojson.addCassette(cassette);
        } catch (DuplicatedCassette duplicatedCassette) {
            ModelAndView m = new ModelAndView("form", "command", cassette);
            m.addObject("typeTypes", Type.values());
            m.addObject("genreTypes", Genre.values());
            m.addObject("message", "EXISTS !" + cassette.getTitle());
            return m;
        }
        ModelAndView m = new ModelAndView("redirect:cassette/" + cassette.getTitle());
        return m;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCassetteForm() {
        ModelAndView m = new ModelAndView("form", "command", new cassette());
        m.addObject("typeTypes", Type.values());
        m.addObject("genreTypes", Genre.values());
        return m;
    }

    @RequestMapping(value = "/cassettes/{title}")
    public ModelAndView getCassetteByTitle(@PathVariable String title) throws IOException, CassetteNotExist {
        ModelAndView m = new ModelAndView("details");
        m.addObject("cassettes", daojson.readCassetteByTitle(title));
        return m;
    }

    @ExceptionHandler(CassetteNotExist.class)
    public ModelAndView CassetteNotExistMissing() {
        ModelAndView m = new ModelAndView("index");
        m.addObject("message", "NOT FOUND!");
        return m;
    }
}
}
