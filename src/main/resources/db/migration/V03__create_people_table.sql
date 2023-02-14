create table peoples (
    id BIGINT(20) primary key auto_increment,
    name VARCHAR(50) not null,
    address varchar(50),
    number varchar(50),
    complement varchar(50),
    neighborhood varchar(50),
    postal_zip varchar(50),
    city varchar(50),
    state varchar(50)
)   ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into peoples ( name, address, number, complement, neighborhood, postal_zip, city, state )
VALUES
    ( 'Diego Mayolo', 'Rua Pacífico', '915', '','Dom Pedro II', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Suelen Delazeri', 'Rua Pacífico', '915', '','Dom Pedro II', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Maria do Carmo', 'Rua das Flores', '1250', 'Apto 04','São Cristovão', '95913004', 'Lajeado', 'Rio Grande do Sul'),
    ( 'Pedro de Oliveira', 'Rua Carlos Fett Filho', '534', '','Centro', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Raul Schmitd', 'Rua Benjamin Constant', '2342', '','Carneiros', '95913‑004', 'Lajeado', 'Rio Grande do Sul'),
    ( 'Olívia Beatriz', 'Rua Atlântico', '92', 'Apto 14','São Caetano', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Ester Richard', 'Rua das Mamadeiras', '776', '','Bela Vista', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Carlos Eduardo dos Santos', 'Rua 666', '123', 'Apto 21 Blobo B','Rui Barbosa', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'José Quinot', 'Rua Marítimo', '110', '','Barra do Forqueta', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Joaquin Binsfeld', 'Rua Sem Idéias', '17', 'Apto 02','São Cristovão', '95913‑004', 'Lajeado', 'Rio Grande do Sul'),
    ( 'Isabella Mayolo Binsfeld', 'Rua das Glórias', '1341', '','Navegantes', '95940000', 'Arroio do Meio', 'Rio Grande do Sul'),
    ( 'Duque Mayolo', 'Rua Pacífico', '754', 'Casa dos fundos','Dom Pedro II', '95940000', 'Arroio do Meio', 'Rio Grande do Sul');
