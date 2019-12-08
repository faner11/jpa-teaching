package com.demo.database.model

import org.hibernate.annotations.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author fh
 * @since 2019/12/7
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "auto_id")
        var autoId: Long? = null,
        var status: Byte? = null,
        @CreationTimestamp
        @Column(name = "create_time")
        var createTime: LocalDateTime? = null,
        @UpdateTimestamp
        @Column(name = "last_modify_time")
        var lastModifyTime: LocalDateTime? = null
)


