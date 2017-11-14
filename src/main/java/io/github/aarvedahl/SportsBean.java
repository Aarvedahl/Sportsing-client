package io.github.aarvedahl;


import com.sportsing.api.ContenderResult;
import com.sportsing.api.Match;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Named
@ViewScoped
public class SportsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Match> matches;
    private static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = client.target("http://localhost:8080/jaxrs-webservice/sportservice/list");


    public List<Match> getMatches() {
        if(matches == null) {
            matches = baseTarget.request().get(new GenericType<List<Match>>() {});
        }
        return matches;
    }

    public void getContenders() {
       // contenders = new ArrayList<ContenderResult>();
        // Needed since getters has not been added to Match
        /*for(Match match : getMatches()) {
            for (Iterator<ContenderResult> iter = match.getContenderIterator(); iter.hasNext(); ) {
                ContenderResult contenderResult = iter.next();
                contenders.add(contenderResult);
                //iter.remove();
            }
        } */
    }
}
