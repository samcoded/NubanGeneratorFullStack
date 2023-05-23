# Backend Developer Application Project (NUBAN GENERATOR)

Create Nuban Number by Inputting Bank Code and Bank Serial Number.
This uses CBN approved algorithm to generate

## Directories

-   NubanGenerator - Backend (Java, Spring Boot, MySQL)
-   NubanGeneratorFrontend - Frontend (Angular)

## Backend

-   Edit `application.properties` in `NubanGenerator/src/main/resources` and add MySQL Details before running Project

```
spring.datasource.url=jdbc:mysql://{HOST}:{PORT}/{DATABASE NAME}?useSSL=false

spring.datasource.username={DATABASE USER}

spring.datasource.password={DATABASE PASSWORD}

```

### Routes

GET - `api/nubans` - View all saved NUBANs

POST - `api/generate` - Generate NUBAN
@body - bankCode, serialNumber

## Frontend

-   Edit `environment.development.ts` in `NubanFrontend/src/environments` and edit the backend api url `apiUrl` before running

```
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api/'
};
```

### Install Dependencies

Install nodejs and npm first before installing dependencies

```
cd NubanFrontend
npm install
```

### Running dev server

Install Angular CLI and run

```
ng serve
```
