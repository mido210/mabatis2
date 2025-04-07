package com.example.mybatis2.memo;

import lombok.*;
import org.springframework.cglib.core.*;

import java.time.*;
// 스프링은 커맨드 객체를  기본생성자로 생성한 다음, setter로 값을 집어넣는다
// 롬북에서@Builer를 사용할 때 @AllArgConstructor도 필요

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Memo {
    private int mno;
    private String title;
    private String content;
    private String writer;
    private LocalDate regDate ;
}
