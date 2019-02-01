package org.jenkinsci.plugins.tuleap_git_branch_source.resteasyclient;


import org.jenkinsci.plugins.tuleap_git_branch_source.client.api.TuleapProject;
import org.jenkinsci.plugins.tuleap_git_branch_source.client.api.TuleapUser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api")
public interface TuleapApiClient {

    String ACCESS_KEY_HEADER = "X-Auth-AccessKey";

    @GET
    @Path("/explorer/swagger.json")
    public Response getApiExplorer() throws ProcessingException;

    @GET
    @Path("/users")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<TuleapUser> getUsers(@HeaderParam(ACCESS_KEY_HEADER) String credential);

    @GET
    @Path("/projects")
    public List<TuleapProject> getProjects(@HeaderParam(ACCESS_KEY_HEADER) String accessKey, @QueryParam("is_member_of") String isMember, @QueryParam("limit") int limit);

}
