package org.kaddiya.mqgror.models.kafka.internal

import groovy.transform.Canonical
import groovy.transform.Immutable
import org.kaddiya.grorchestrator.models.remotedocker.responses.AbstractDockerInteractionResponse

/**
 * Created by Webonise on 22/02/17.
 */
@Canonical
class OrchestrationResult {
    Long taskId
    Boolean sucess
    AbstractDockerInteractionResponse interactionResponse
}
