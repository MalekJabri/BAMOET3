package org.kie.kogito.examples;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MockService {

    public Response execute(String failClass, Class clazz, boolean throwException) {
        boolean fail = Optional.ofNullable(clazz)
                .map(Class::getSimpleName)
                .map(n -> Objects.equals(failClass, n))
                .orElse(false);
        if (fail && throwException) {
            throw new ServiceException("Error executing " + failClass);
        }
        return new Response(fail ? Response.Type.ERROR : Response.Type.SUCCESS,
                UUID.randomUUID().toString());
    }
}
