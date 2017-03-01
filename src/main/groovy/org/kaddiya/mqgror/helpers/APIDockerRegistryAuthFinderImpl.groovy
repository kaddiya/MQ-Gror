package org.kaddiya.mqgror.helpers

import org.kaddiya.grorchestrator.helpers.DockerRegistryAuthFinder
import org.kaddiya.grorchestrator.models.core.DockerHubAuth

/**
 * Created by Webonise on 01/03/17.
 */
class APIDockerRegistryAuthFinderImpl implements DockerRegistryAuthFinder {

    @Override
    DockerHubAuth getDockerHubAuthForId(String s) {
        return new DockerHubAuth(s, System.getenv("dhusername"), System.getenv("dhpassword"), System.getenv("dhemail"), " ")
    }
}
