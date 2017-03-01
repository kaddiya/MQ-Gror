package org.kaddiya.mqgror.models.kafka

import groovy.transform.Canonical
import groovy.transform.Immutable
import org.kaddiya.grorchestrator.models.core.DockerHubAuth
import org.kaddiya.grorchestrator.models.core.SupportedContainerActions
import org.kaddiya.grorchestrator.models.core.latest.Host
import org.kaddiya.grorchestrator.models.core.latest.Instance

/**
 * Created by Webonise on 22/02/17.
 */
@Canonical
class RequestMessage {
    Host host
    Instance instance
    SupportedContainerActions action
}
