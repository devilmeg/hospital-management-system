package com.hms.hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Block")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Block {
    @EmbeddedId
    private Block_Id blockId;
//    @Column(name = "BlockFloor")              // we can not use @coloumn with entity in base class when using @Embadable . We can do that with @IdClass if we want .

}
