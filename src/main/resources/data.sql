INSERT INTO CONTA VALUES('875e4a2e-c44c-420c-8368-99d21842706a',123,25040,'CONTACORRENTEPJ',10999,1);
INSERT INTO CONTA VALUES('f0c4999f-a2d4-48c0-a78f-efb3a1ded4a5', 123,25041,'CONTACORRENTEPF',5000,1);
INSERT INTO CONTA VALUES ('d4130b7b-42a1-4608-83fe-d80a9846f86f',123,25043,'CONTAPOUPANCA',2000,1);



INSERT INTO ENDERECO VALUES (99,'Cidade Satélite','12941490','Atibaia','lj01',239,'Rua Itaú','SP');
INSERT INTO ENDERECO VALUES (100,'Iririu','89224150', 'Joinville', 'apt303', 323, 'Rua Cegonhas','SC');
INSERT INTO ENDERECO VALUES (101,'Jardim das Orquídeas','13453732','Santa Bárbara Oeste','',549,'Rua Cesarino Scagnolato','SP');


INSERT INTO PESSOA_JURIDICA VALUES (99, now(), '6525283206', now(), 'almoxarifado@contabilltda.com.br', 'jose e maria Contábil Ltda', 1,'1126675385','34213050000179', 'jose','jose e maria Contábil Ltda', '875e4a2e-c44c-420c-8368-99d21842706a', 99);

INSERT INTO PESSOA_FISICA VALUES (100, now(), '87985390961', now(), 'fulana@sigi.com', 'Fulana de tal', 1,'8737827184','87985390961','1981-09-15','FEMININO','56320060',   'f0c4999f-a2d4-48c0-a78f-efb3a1ded4a5', 100);
INSERT INTO PESSOA_FISICA VALUES (101, now(), '63989426684', now(), 'Allan@sigi.com', 'Allan Almeida', 1, '6326574436','24176339225','1980-10-15','MASCULINO','482212329',    'd4130b7b-42a1-4608-83fe-d80a9846f86f',101);


INSERT INTO TRANSACAO VALUES ('ff137a77-e363-471d-a03a-225e1f9252e7', now(),  'Pagamento de compra', 'PIX',  59.50, 'd4130b7b-42a1-4608-83fe-d80a9846f86f','f0c4999f-a2d4-48c0-a78f-efb3a1ded4a5');
INSERT INTO TRANSACAO VALUES ('cc17c138-33f3-481a-adb6-22436dbb2473',  now(), 'pagamento de pedido', 'PIX', 1999.50, 'f0c4999f-a2d4-48c0-a78f-efb3a1ded4a5', '875e4a2e-c44c-420c-8368-99d21842706a');
