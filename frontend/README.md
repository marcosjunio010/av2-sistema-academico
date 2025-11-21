# Sistema Acadêmico - Frontend (simples)

Este é um frontend bem simples em React + Vite para consumir a API do sistema acadêmico.

## Tecnologias usadas

- React
- Vite
- Fetch API para acessar o backend

## Como rodar localmente

1. Entrar na pasta `frontend`
2. Rodar:

```bash
npm install
npm run dev
```

3. Por padrão o Vite sobe em `http://localhost:5173`

## Como a API é consumida

No projeto usei uma variável de ambiente para a URL da API:

- arquivo `.env` (na pasta `frontend`)
- exemplo:

```env
VITE_API_URL=http://localhost:8080
```

No código, as chamadas usam `import.meta.env.VITE_API_URL` como base para acessar endpoints do backend.

## Deploy no Vercel (idea geral)

Passos que eu seguiria para publicar o frontend:

1. Garantir que o projeto está no GitHub
2. Criar uma conta na Vercel (se ainda não tiver)
3. Em **New Project**, importar o repositório do frontend
4. A Vercel detecta automaticamente Vite/React
5. Configurar a variável de ambiente `VITE_API_URL` na Vercel apontando para a URL do backend (ex: backend no Render)
6. Concluir o deploy e testar a aplicação pelo link gerado

A ideia é simples: o backend fica publicado no Render e o frontend no Vercel, usando a URL pública da API.
