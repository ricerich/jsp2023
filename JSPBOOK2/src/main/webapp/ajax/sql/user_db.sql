
drop table user_info_sample;

create table user_info_sample ( 
    u_id varchar2(10) not null,
    u_name varchar2(20) not null,   
    u_phone varchar2(20),
    u_grade number,
    write_time date,
    primary key(u_id) 
) ;

INSERT INTO user_info_sample VALUES('hkd','홍길동','010-1234-1000',3,sysdate);
INSERT INTO user_info_sample VALUES('ggc','강감찬','010-2222-2200',6,sysdate);
INSERT INTO user_info_sample VALUES('lee','이순신','010-9999-3333',2,sysdate);

commit;