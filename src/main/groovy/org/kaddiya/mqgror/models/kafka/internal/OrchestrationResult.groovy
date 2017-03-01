package org.kaddiya.mqgror.models.kafka.internal

import groovy.transform.Canonical
import org.kaddiya.grorchestrator.models.remotedocker.responses.AbstractDockerInteractionResponse

import java.time.Instant

/**
 * Created by Webonise on 22/02/17.
 */
@Canonical
class OrchestrationResult {
    Long taskId
    Boolean sucess
    AbstractDockerInteractionResponse interactionResponse
    Instant endTime
    Instant startTime

}
