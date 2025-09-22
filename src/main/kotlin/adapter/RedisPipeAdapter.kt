package hse.pipo.adapter

import hse.pipo.dto.PipeAuthority
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class RedisPipeAdapter(
    private val redisTemplate: RedisTemplate<String, Any>

) : PipeAdapter {
    override fun createConsumerAuthority(tenant: String): PipeAuthority? {
        val password = UUID.randomUUID().toString()
        val username = "$tenant-${UUID.randomUUID()}"
        val created = redisTemplate.execute { connection ->
            val args = listOf(
                "SETUSER", tenant, "on", ">$password",
                "~$tenant", "+subscribe", "-@all"
            )
            String(connection.execute("ACL", *args.map { it.toByteArray() }.toTypedArray()) as ByteArray)
        } ?: return null
        return if (created == "OK") {
            PipeAuthority(username, password)
        } else null
    }

    override fun deleteConsumer(username: String) {
        redisTemplate.execute { connection ->
            connection.execute("ACL", "DELUSER".toByteArray(), username.toByteArray())
        }
    }
}