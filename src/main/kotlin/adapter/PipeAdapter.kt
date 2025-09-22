package adapter

import hse.pipo.dto.PipeAuthority

interface PipeAdapter {
    fun createConsumerAuthority(tenant: String): PipeAuthority?

    fun deleteConsumer(username: String)
}