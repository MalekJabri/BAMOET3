package org.acme.travels.services;

import org.acme.travels.quarkus.User;
import org.acme.travels.rest.UsersRemoteService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    @RestClient
    UsersRemoteService usersRemoteService;

    @Fallback(fallbackMethod = "missingUser")
    public User get(String username) {
        return usersRemoteService.get(username);
    }

    public User missingUser(String username) {
        return null;
    }
}
