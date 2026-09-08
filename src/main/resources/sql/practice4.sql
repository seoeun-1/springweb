INSERT INTO course (course_name, created_at, updated_at) VALUES ('자바 백엔드 개발자 과정', NOW(), NOW());
INSERT INTO course (course_name, created_at, updated_at) VALUES ('프론트엔드 React 과정', NOW(), NOW());
INSERT INTO student (student_name, created_at, updated_at) VALUES ('김철수', NOW(), NOW());
INSERT INTO student (student_name, created_at, updated_at) VALUES ('이영희', NOW(), NOW());
INSERT INTO enroll (status, course_id, student_id, created_at, updated_at) VALUES ('수강중', 1, 1, NOW(), NOW());
INSERT INTO enroll (status, course_id, student_id, created_at, updated_at) VALUES ('수강중', 1, 2, NOW(), NOW());