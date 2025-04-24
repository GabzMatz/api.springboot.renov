
-- Tabela: Usuario
CREATE TABLE Usuario (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    Senha VARCHAR(255) NOT NULL,
    TipoUsuario VARCHAR(50) NOT NULL,
    DataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    UltimaAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabela: Endereco
CREATE TABLE Endereco (
    EnderecoID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT NOT NULL,
    Logradouro VARCHAR(100) NOT NULL,
    Numero VARCHAR(20),
    Complemento VARCHAR(100),
    Bairro VARCHAR(100),
    Cidade VARCHAR(100),
    Estado VARCHAR(50),
    CEP VARCHAR(20),
    DataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    UltimaAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID)
);

-- Tabela: TipoEquipamento
CREATE TABLE TipoEquipamento (
    TipoEquipamentoID INT AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(100) NOT NULL
);

-- Tabela: TipoManutencao
CREATE TABLE TipoManutencao (
    TipoManutencaoID INT AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(100) NOT NULL
);

-- Tabela: TipoAlerta
CREATE TABLE TipoAlerta (
    TipoAlertaID INT AUTO_INCREMENT PRIMARY KEY,
    Descricao VARCHAR(100) NOT NULL
);

-- Tabela: Equipamento
CREATE TABLE Equipamento (
    EquipamentoID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT NOT NULL,
    TipoEquipamentoID INT NOT NULL,
    Modelo VARCHAR(100),
    NumeroSerie VARCHAR(100),
    DataInstalacao DATE,
    VidaUtilEstimada INT,
    Status VARCHAR(50),
    Localizacao VARCHAR(255),
    UsoAcumulado INT,
    DataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    UltimaAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID),
    FOREIGN KEY (TipoEquipamentoID) REFERENCES TipoEquipamento(TipoEquipamentoID)
);

-- Tabela: Manutencao
CREATE TABLE Manutencao (
    ManutencaoID INT AUTO_INCREMENT PRIMARY KEY,
    EquipamentoID INT NOT NULL,
    TipoManutencaoID INT NOT NULL,
    DataManutencao DATE,
    Descricao VARCHAR(255),
    CustoEstimado DECIMAL(10,2),
    Responsavel VARCHAR(100),
    DataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    UltimaAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (EquipamentoID) REFERENCES Equipamento(EquipamentoID),
    FOREIGN KEY (TipoManutencaoID) REFERENCES TipoManutencao(TipoManutencaoID)
);

-- Tabela: Alerta
CREATE TABLE Alerta (
    AlertaID INT AUTO_INCREMENT PRIMARY KEY,
    EquipamentoID INT NOT NULL,
    TipoAlertaID INT NOT NULL,
    DataAlerta DATE,
    Mensagem VARCHAR(255),
    Status VARCHAR(50),
    DataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    UltimaAtualizacao DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (EquipamentoID) REFERENCES Equipamento(EquipamentoID),
    FOREIGN KEY (TipoAlertaID) REFERENCES TipoAlerta(TipoAlertaID)
);
