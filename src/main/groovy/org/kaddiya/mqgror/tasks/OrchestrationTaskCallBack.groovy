package org.kaddiya.mqgror.tasks

import com.google.common.util.concurrent.FutureCallback
import groovy.util.logging.Slf4j
import org.kaddiya.mqgror.models.kafka.internal.OrchestrationResult

/**
 * Created by Webonise on 01/03/17.
 */
@Slf4j
class OrchestrationTaskCallBack implements FutureCallback<OrchestrationResult> {


    public OrchestrationTaskCallBack() {

    }

    @Override
    void onSuccess(OrchestrationResult result) {

        log.info("tasks with id : {} has been executed {}", result.taskId, result.sucess)
    }

    @Override
    void onFailure(Throwable t) {
        log.info(t.message)
    }
}
