-- Table task
CREATE TABLE IF NOT EXISTS tasks (
    id UUID PRIMARY KEY,  -- UUID généré côté Spring Boot
    title VARCHAR(70) NOT NULL UNIQUE,
    description VARCHAR(200),
    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE
);
