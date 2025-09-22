package hse.pipo.service

import hse.pipo.dto.PipeAuthority

interface ConsumerService {
    fun getConnectionAuthority(tenant: String): PipeAuthority?
}