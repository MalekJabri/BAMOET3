package org.kie.kogito.examples.springboot;

import java.io.IOException;
import java.util.Properties;

public class ProjectMetadataProvider {

    private static final Properties props = new Properties();

    private static final String projectVersion;
    private static final String projectArtifactId;

    static {
        String propertyFileName = "project.properties";
        try {
            props.load(GrafanaDockerComposeIT.class.getClassLoader().getResourceAsStream(propertyFileName));
            projectVersion = props.getProperty("project.version");
            projectArtifactId = props.getProperty("project.artifactId");
        } catch (IOException e) {
            throw new IllegalStateException("Impossible to retrieve property file " + propertyFileName, e);
        }
        if (projectVersion == null || projectArtifactId == null || projectVersion.startsWith("${") || projectArtifactId.startsWith("${")) {
            throw new IllegalStateException("The projectVersion and/or the projectArtifactId maven properties are not configured properly.");
        }
    }

    public static String getProjectVersion() {
        return projectVersion;
    }

    public static String getProjectArtifactId() {
        return projectArtifactId;
    }
}
