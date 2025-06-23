# 🏷️ POS Inventory Service

Spring Boot 기반의 재고 관리 마이크로서비스입니다.  
상품별 재고 조회 및 수량 차감 기능을 제공하며, 분리된 `pos-common` 공통 모듈을 참조합니다.

---

## ✅ Features

- 재고 수량 조회 및 차감 API
- 주문 서비스 연동 (`pos-order-service`)
- 공통 API 응답 구조 적용 (`ApiResponse`)
- Swagger 기반 REST API 문서 제공
- Gradle 기반 빌드 및 Docker 배포 지원
- MSA 아키텍처 구성

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3.3.x
- Gradle 8.x
- Spring Web, Spring Data JPA
- Springdoc OpenAPI (Swagger UI)
- Docker
- GitHub Actions (예정)

---

## 📁 프로젝트 구조

```
pos-inventory-service/
├── src/
│   ├── main/
│   │   ├── java/com/example/inventoryservice
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── model
│   │   │   └── repository
│   ├── test/
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 🚀 실행 방법

### 1. 사전 준비

- Java 17 이상
- Gradle 설치 (또는 Gradle Wrapper 사용)
- 로컬 Maven 저장소에 `pos-common` 사전 배포 필요:

```bash
cd ~/projects/pos-common
./gradlew clean publishToMavenLocal
```

### 2. 프로젝트 실행

```bash
cd ~/projects/pos-inventory-service
./gradlew clean build
./gradlew bootRun
```

> 기본 포트는 `8082` (설정 확인 필요)

---

## 📡 API 사용 예시

### ✅ 서버 상태 확인

```
GET /api/inventory/test
```

응답:

```json
{
  "data": "Inventory service is running!",
  "code": "inventory-ok"
}
```

---

### 📦 재고 조회

```
GET /api/inventory/{itemName}
```

---

### 📦 재고 차감

```
POST /api/inventory/decrease
Content-Type: application/json

{
  "itemName": "bolt",
  "quantity": 5
}
```

---

## 📚 Swagger 문서

실행 후 아래 경로에서 확인:

```
http://localhost:8082/swagger-ui/index.html
```

---

## 🔗 관련 프로젝트

| 서비스                                                                   | 설명                          |
| ------------------------------------------------------------------------ | ----------------------------- |
| [pos-common](https://github.com/grshin/pos-common)                       | 공통 DTO 및 응답 포맷 제공    |
| [pos-order-service](https://github.com/grshin/pos-order-service)         | 주문 처리 마이크로서비스      |
| [pos-api-gateway](https://github.com/grshin/pos-api-gateway)             | API 통합 및 라우팅 게이트웨이 |

---

## 🛠️ 향후 확장 예정

- Spring Cloud Eureka 연동 (서비스 디스커버리)
- Spring Cloud Config (설정 분리)
- JWT 기반 인증/인가 적용
- GitHub Actions 기반 CI/CD 파이프라인

---

## 👤 Author

- **grshin**
- [GitHub](https://github.com/grshin)