package org.kaddiya.mqgror.models.kafka.internal

import groovy.transform.Immutable

/**
 * Created by Webonise on 22/02/17.
 */
@Immutable
class OrchestrationResult {
    Long taskId
    Boolean sucess
}
