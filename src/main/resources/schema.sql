-- schema.sql - Criação das tabelas

CREATE TABLE tb_user (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) UNIQUE NOT NULL,
                         password VARCHAR(255) NOT NULL
);

CREATE TABLE tb_role (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         authority VARCHAR(255) NOT NULL
);

CREATE TABLE tb_user_role (
                              user_id BIGINT NOT NULL,
                              role_id BIGINT NOT NULL,
                              PRIMARY KEY (user_id, role_id),
                              FOREIGN KEY (user_id) REFERENCES tb_user(id),
                              FOREIGN KEY (role_id) REFERENCES tb_role(id)
);

CREATE TABLE tb_course (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           img_Uri VARCHAR(500),
                           img_Gray_Uri VARCHAR(500)
);

CREATE TABLE tb_offer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          edition VARCHAR(255),
                          start_Moment TIMESTAMP WITH TIME ZONE,
                          end_Moment TIMESTAMP WITH TIME ZONE,
                          course_id BIGINT NOT NULL,
                          FOREIGN KEY (course_id) REFERENCES tb_course(id)
);

CREATE TABLE tb_resource (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             title VARCHAR(255) NOT NULL,
                             description TEXT,
                             position INTEGER,
                             img_Uri VARCHAR(500),
                             type VARCHAR(50),
                             offer_id BIGINT NOT NULL,
                             FOREIGN KEY (offer_id) REFERENCES tb_offer(id)
);

CREATE TABLE tb_section (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            title VARCHAR(255) NOT NULL,
                            description TEXT,
                            position INTEGER,
                            img_Uri VARCHAR(500),
                            resource_id BIGINT NOT NULL,
                            prerequisite_id BIGINT,
                            FOREIGN KEY (resource_id) REFERENCES tb_resource(id),
                            FOREIGN KEY (prerequisite_id) REFERENCES tb_section(id)
);

CREATE TABLE tb_enrollment (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               user_id BIGINT NOT NULL,
                               offer_id BIGINT NOT NULL,
                               enroll_Moment TIMESTAMP WITH TIME ZONE,
                               refund_Moment TIMESTAMP WITH TIME ZONE,
                               available BOOLEAN DEFAULT true,
                               only_Update BOOLEAN DEFAULT false,
                               FOREIGN KEY (user_id) REFERENCES tb_user(id),
                               FOREIGN KEY (offer_id) REFERENCES tb_offer(id)
);

CREATE TABLE tb_lesson (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           position INTEGER,
                           section_id BIGINT NOT NULL,
                           FOREIGN KEY (section_id) REFERENCES tb_section(id)
);

CREATE TABLE tb_content (
                            id BIGINT PRIMARY KEY,
                            text_Content TEXT,
                            video_Uri VARCHAR(500),
                            FOREIGN KEY (id) REFERENCES tb_lesson(id)
);

CREATE TABLE tb_task (
                         id BIGINT PRIMARY KEY,
                         description TEXT,
                         question_Count INTEGER,
                         approval_Count INTEGER,
                         weight DECIMAL(5,2),
                         due_Date TIMESTAMP WITH TIME ZONE,
                         FOREIGN KEY (id) REFERENCES tb_lesson(id)
);

CREATE TABLE tb_lessons_done (
                                 lesson_id BIGINT NOT NULL,
                                 user_id BIGINT NOT NULL,
                                 offer_id BIGINT NOT NULL,
                                 PRIMARY KEY (lesson_id, user_id, offer_id),
                                 FOREIGN KEY (lesson_id) REFERENCES tb_lesson(id),
                                 FOREIGN KEY (user_id) REFERENCES tb_user(id),
                                 FOREIGN KEY (offer_id) REFERENCES tb_offer(id)
);

CREATE TABLE tb_notification (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 text TEXT NOT NULL,
                                 moment TIMESTAMP WITH TIME ZONE,
                                 read BOOLEAN DEFAULT false,
                                 route VARCHAR(500),
                                 user_id BIGINT NOT NULL,
                                 FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_deliver (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            uri VARCHAR(500),
                            moment TIMESTAMP WITH TIME ZONE,
                            status INTEGER,
                            feedback TEXT,
                            correct_Count INTEGER,
                            lesson_id BIGINT NOT NULL,
                            user_id BIGINT NOT NULL,
                            offer_id BIGINT NOT NULL,
                            FOREIGN KEY (lesson_id) REFERENCES tb_lesson(id),
                            FOREIGN KEY (user_id) REFERENCES tb_user(id),
                            FOREIGN KEY (offer_id) REFERENCES tb_offer(id)
);

CREATE TABLE tb_topic (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          body TEXT,
                          moment TIMESTAMP WITH TIME ZONE,
                          author_id BIGINT NOT NULL,
                          offer_id BIGINT NOT NULL,
                          lesson_id BIGINT,
                          FOREIGN KEY (author_id) REFERENCES tb_user(id),
                          FOREIGN KEY (offer_id) REFERENCES tb_offer(id),
                          FOREIGN KEY (lesson_id) REFERENCES tb_lesson(id)
);

CREATE TABLE tb_topic_likes (
                                topic_id BIGINT NOT NULL,
                                user_id BIGINT NOT NULL,
                                PRIMARY KEY (topic_id, user_id),
                                FOREIGN KEY (topic_id) REFERENCES tb_topic(id),
                                FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_reply (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          body TEXT NOT NULL,
                          moment TIMESTAMP WITH TIME ZONE,
                          topic_id BIGINT NOT NULL,
                          author_id BIGINT NOT NULL,
                          FOREIGN KEY (topic_id) REFERENCES tb_topic(id),
                          FOREIGN KEY (author_id) REFERENCES tb_user(id)
);

CREATE TABLE tb_reply_likes (
                                reply_id BIGINT NOT NULL,
                                user_id BIGINT NOT NULL,
                                PRIMARY KEY (reply_id, user_id),
                                FOREIGN KEY (reply_id) REFERENCES tb_reply(id),
                                FOREIGN KEY (user_id) REFERENCES tb_user(id)
);