package org.kaddiya.mqgror.tasks

import com.google.common.util.concurrent.FutureCallback
import groovy.util.logging.Slf4j
import org.kaddiya.mqgror.models.kafka.internal.OrchestrationResult

/**
 * Created by Webonise on 01/03/17.
 */
@Slf4j
class OrchestrationTaskCallBack implements FutureCallback<OrchestrationResult> {

    private Long taskId

    public OrchestrationTaskCallBack(Long taskId) {
        this.taskId = taskId
        log.info("Registered a callback for task Id {}",taskId)
    }

    @Override
    void onSuccess(OrchestrationResult result) {
        if(taskId != result.taskId){
            throw IllegalStateException("Callback's task id: "+taskId+"doesnt match the task's taskId : "+result.getTaskId())
        }
        log.info("tasks with id : {} has been executed {}", result.taskId, result.sucess)
    }

    @Override
    void onFailure(Throwable t) {
        log.error(t.message)
    }
}
