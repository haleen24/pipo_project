package org.example.service

import org.example.dto.PipeAuthority

interface ConsumerService {
    fun getConnectionAuthority(tenant: String): PipeAuthority
}