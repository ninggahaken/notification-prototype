package com.daya.notification_prototype.domain.settings

import com.daya.notification_prototype.data.topic.Topic
import com.daya.notification_prototype.data.topic.TopicRepository
import com.daya.notification_prototype.di.IoDispatcher
import com.daya.notification_prototype.domain.UseCase
import com.daya.notification_prototype.util.mapToTopicNet
import kotlinx.coroutines.CoroutineDispatcher

class SubscribeTopicUseCase(
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
        private val repo : TopicRepository
) : UseCase<Topic,Boolean>(coroutineDispatcher) {

    override suspend fun execute(parameters: Topic): Boolean {
        val topicNet = parameters.mapToTopicNet()
        return repo.subscribeTopic(topicNet)
    }

}