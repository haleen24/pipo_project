package hse.pipo.service

import hse.pipo.adapter.PipeAdapter
import hse.pipo.dto.PipeAuthority

class ConsumerServiceImpl(
    private val pipeAdapter: PipeAdapter
) : ConsumerService {
    override fun getConnectionAuthority(tenant: String): PipeAuthority? = pipeAdapter.createConsumerAuthority(tenant)
}