CREATE TABLE Questions (id serial PRIMARY KEY,text VARCHAR(10000) NOT NULL);
CREATE TABLE Answers (answer serial PRIMARY KEY,text VARCHAR(10000));

INSERT INTO Questions (text) VALUES ('1. Я люблю читать научно-техническую литературу');
INSERT INTO Questions (text) VALUES ('2. У меня хороший аппетит');
INSERT INTO Questions (text) VALUES ('3. По утрам я обычно встаю свежим и отдохнувшим');
INSERT INTO Questions (text) VALUES ('4. Думаю, что мне понравилась бы работа библиотекаря');
INSERT INTO Questions (text) VALUES ('5. Малейший шум меня будит');
INSERT INTO Questions (text) VALUES ('6. Я люблю читать в газетах заметки о преступлениях');
