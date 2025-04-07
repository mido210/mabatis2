package com.example.mybatis2.memo;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

@Mapper
public interface MemoDao {
    @Insert("insert into memo(mno,title,content,writer) values(MEMO_SEQ.nextval,#{title},#{content},#{writer})")
    int save(Memo memo);

    @Select("select mno,title,writer, red_date as regDate from memo")
    List<Memo> findAll();

    // rownum=1로 결과의 개수를 오라클에게 알려준다
    @Select("select * from memo where mno=#{mno} and rownum=1")
    Optional<Memo> findByMno(int mno);

    @Update("update memo set content=#{content} where mno=#{mno} and rownum=1")
    int update(String content, int mno);

    @Delete("delete from memo where mno=#{mno}")
    int delete(int mno);

}
