package com.demo.database.model

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author fh
 * @since 2019/12/7
 */
@Entity
@Table(name = "t_user")
@Where(clause = "status=0")
@SQLDelete(sql="UPDATE t_user SET status = 1 WHERE auto_id = ?")
@DynamicInsert
@DynamicUpdate
class User(
        var name: String? = null,
        var age: Int? = null
) : BaseEntity()