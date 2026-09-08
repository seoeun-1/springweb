package example.test.model.dto;

import java.time.LocalDateTime;

import example.test.model.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor@Data@Builder 
public class CommentDto {
    private Integer id;
    private String author;
    private String password;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private Integer boardId;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
            .content( this.content )
            .author( this.author )
            .password( this.password )
            .build();
    }

    public static CommentDto from( CommentEntity entity ){
        return CommentDto.builder()
                .id( entity.getId() )
                .author( entity.getAuthor() )
                .password( entity.getPassword() )
                .content( entity.getContent() )
                .createdAt( entity.getCreatedAt() )
                .updatedAt( entity.getUpdatedAt() )
                .build();
    }
}
