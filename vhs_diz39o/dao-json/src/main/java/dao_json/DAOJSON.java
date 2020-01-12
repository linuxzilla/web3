package dao_json;

import cassettes.model.Cassette;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DAOJSON {
    File file;
    ObjectMapper mapper;

    public DAOJSON(String filePath) throws IOException {
        this.file = new File(filePath);
        this.mapper = new ObjectMapper();
        mapper.registerModule((new JavaTimeModule()));
        if(!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(("[]"));
            writer.close();
        }
    }

    public Cassette readCassetteByTitle(String title) throws IOException, CassetteNotExist {
        Collection<Cassette> cassettes = readAllCassette();
        for (Cassette c: cassettes) {
            if (c.getTitle().equalsIgnoreCase(title)){
                return c;
            }
        }
        throw new CassetteNotExist();
    }

    public Collection<Cassette> readAllCassette() throws IOException {
        Collection<Cassette> r = new ArrayList<>();
        r = mapper.readValue(file, new TypeReference<ArrayList<Cassette>>(){});
        return r;
    }

    public void addCassette(Cassette cassette) throws IOException, DuplicatedCassette {
        try
        {
            readCassetteByTitle(cassette.getTitle());
        }
        catch (CassetteNotExist cassetteNotExist)
        {
            Collection<Cassette> cassettes = readAllCassette();
            cassettes.add(cassette);
            mapper.writeValue(file, cassettes);
            return;
        }
        throw new DuplicatedCassette(cassette.getTitle());
    }
}
