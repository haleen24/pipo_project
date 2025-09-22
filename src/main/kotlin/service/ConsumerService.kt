package hse.pipo.service

import hse.pipo.dto.PipeAuthority

interface ConsumerService {
    fun getConnectionAuthority(tenant: String, env: String): PipeAuthority?

    fun deleteConsumer(login: String)
}