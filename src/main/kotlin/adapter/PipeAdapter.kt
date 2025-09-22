package org.example.adapter

import org.example.dto.PipeAuthority

interface PipeAdapter {
    fun createConsumerAuthority(tenant: String): PipeAuthority?

    fun deleteConsumer(username: String)
}