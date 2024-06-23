package com.mycompany.sql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SqlParserTest {
    private SqlParser instance;

    @BeforeEach
    public void init() {
        instance = new SqlParser();
    }

    @Test
    public void testSqlParser1() {
        instance.parse("""
                SELECT student_id, COUNT(student_id)
                FROM tbl_scores
                GROUP BY student_id
                HAVING COUNT(student_id)> 1
                ORDER BY student_id;
                """);
    }

    @Test
    public void testSqlParser2() {
        instance.parse("""
                SELECT student_id, score
                FROM tbl_scores
                ORDER BY student_id
                FETCH FIRST ROW ONLY;
                """);
    }

    @Test
    public void testSqlParser3() {
        instance.parse("""
                SELECT DISTINCT ON
                student_id, score
                FROM tbl_scores
                WHERE score > (
                SELECT AVG (score) FROM tbl_scores;
                );
                """);
    }

    @Test
    public void testSqlParser4() {
        instance.parse("""
                select n1.name, n1.author_id, count_1, total_count
                    from (select id, name, author_id, count(1) as count_1
                            from names
                            group by id, name, author_id) n1
                  inner join (select id, author_id, count(1) as total_count
                                from names
                                group by id, author_id) n2
                on (n2.id = n1.id and n2.author_id = n1.author_id);
                """);
    }
}
