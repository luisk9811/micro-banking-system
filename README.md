# Taller final curso de microservicios

## 1. API Gateway
- Punto de entrada único para todas las peticiones de clientes
- Enrutamiento de solicitudes a los microservicios correspondientes

## 2. Servicio de autenticación
- Registro de usuarios
- Autenticación
- Encriptación de contraseñas
- Generación de tokens
- Protección de rutas usando JWT
- Los usuarios se deben almacenar en una base de datos MongoDB
  
## 3. Servicio de Bancos
- Gestión de Bancos (creación, consulta, modificación)
- Exposición de API REST para operaciones CRUD de Bancos

## 4. Servicio de Cuentas
- Gestión de cuentas bancarias (creación, consulta, modificación)
- Conexión con microservicio de bancos para validar que el banco en el que se está tratando de crear la cuenta sí exista (usando peticiones REST).
- Historial de movimientos que se obtienen a través de una consulta al módulo de transacciones (usando gRPC).
- Exposición de API REST para operaciones CRUD de cuentas

## 5. Servicio de Transacciones
- Procesamiento de transferencias entre cuentas y bancos. Si la transferencia es entre cuentas del mismo banco, simplemente debe generarse una transacción de tipo retiro en la cuenta de la que se saca el dinero y otra transacción de tipo depósito en la cuenta a la que se ingresa el dinero. Si la transacción es interbancaria, debe generarse una transacción de tipo retiro en la cuenta de la que se saca el dinero y debe enviarse a una cola de mensajería una transacción de tipo depósito para la cuenta a la que se ingresará el dinero.
- Registro de depósitos y retiros
- Validación de fondos suficientes

## 6. Servicio de Transferencias
- Listener de transferencias que procesará las transferencias interbancarias añadiendo un impuesto y guardando la transacción en la base de datos de transacciones.

## 7. Cobertura de pruebas igual o superior al 80%


# Solución
- Colección de Postman:

```json
{
	"info": {
		"_postman_id": "3297499e-d178-4d19-9c40-73dac7c31320",
		"name": "micro-banking-system",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "23509238",
		"_collection_link": "https://interstellar-shuttle-453758.postman.co/workspace/cursos~f46a7a24-d557-422c-bd7d-e1aba702bf76/collection/23509238-3297499e-d178-4d19-9c40-73dac7c31320?action=share&source=collection_link&creator=23509238"
	},
	"item": [
		{
			"name": "Api-Gateway",
			"item": [
				{
					"name": "Banks",
					"item": [
						{
							"name": "Get Banks",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Bank By Id",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/banks/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"banks",
										"1"
									]
								}
							},
							"response": []
						},
						{
							"name": "Create Bank",
							"request": {
								"method": "POST",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"name\": \"Nubank\",\r\n    \"description\": \"Neo bancos\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						},
						{
							"name": "Update Bank",
							"request": {
								"method": "PUT",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"bankId\": 16,\r\n    \"name\": \"Nubank\",\r\n    \"description\": \"Neo bancos\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Accounts",
					"item": [
						{
							"name": "Get Accounts",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Account By Number",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/accounts/0000000001",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"accounts",
										"0000000001"
									]
								}
							},
							"response": []
						},
						{
							"name": "Create Account",
							"request": {
								"method": "POST",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"accountType\": \"AHORROS\",\r\n    \"balance\": 100000.00,\r\n    \"status\": \"active\",\r\n    \"bankId\": 6\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Update Account",
							"request": {
								"method": "PUT",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"accountNumber\": \"0000000005\",\r\n    \"accountType\": \"CORRIENTE\",\r\n    \"balance\": 75000.00,\r\n    \"status\": \"active\",\r\n    \"bankId\": 2\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Movements By accountNumber",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/accounts/movements/00000000001",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"accounts",
										"movements",
										"00000000001"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Transference",
					"item": [
						{
							"name": "Get Transferences",
							"request": {
								"method": "GET",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"url": {
									"raw": "http://localhost:8080/api/transfer",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"transfer"
									]
								}
							},
							"response": []
						},
						{
							"name": "Make Transfer",
							"request": {
								"method": "POST",
								"header": [
									{
										"key": "Authorization",
										"value": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzayIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNzQ4MDExNTQ5LCJleHAiOjE3NDgwOTc5NDl9.IVJZxpQWytM3YswM33bkoVX0u4k-Jmjt191TzUt0KP7Yv19zKVRW77xHqpbQ-ubwuVwU4l2GoYYXrq9gTdq6pg",
										"type": "text"
									}
								],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"sourceAccountId\": \"00000000001\",\r\n    \"destinationAccountId\": \"00000000003\",\r\n    \"amount\": 10.00\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/api/transfer",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"api",
										"transfer"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Register",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"username\": \"luisk\",\r\n    \"password\": \"123456\",\r\n    \"role\": \"ADMIN\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/auth/register",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"auth",
								"register"
							]
						}
					},
					"response": []
				},
				{
					"name": "Login",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"username\": \"luisk\",\r\n    \"password\": \"123456\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/api/auth/login",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"api",
								"auth",
								"login"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Direct-To-Microservice",
			"item": [
				{
					"name": "Banks",
					"item": [
						{
							"name": "Get Banks",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8081/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8081",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Bank By Id",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8081/api/banks/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8081",
									"path": [
										"api",
										"banks",
										"1"
									]
								}
							},
							"response": []
						},
						{
							"name": "Create Bank",
							"request": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"name\": \"Nubank\",\r\n    \"description\": \"Neo bancos\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8081/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8081",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						},
						{
							"name": "Update Bank",
							"request": {
								"method": "PUT",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"bankId\": 16,\r\n    \"name\": \"Nubank\",\r\n    \"description\": \"Neo bancos\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8081/api/banks",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8081",
									"path": [
										"api",
										"banks"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Accounts",
					"item": [
						{
							"name": "Get Accounts",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8082/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8082",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Account By Number",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8082/api/accounts/0000000001",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8082",
									"path": [
										"api",
										"accounts",
										"0000000001"
									]
								}
							},
							"response": []
						},
						{
							"name": "Create Account",
							"request": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"accountType\": \"AHORROS\",\r\n    \"balance\": 100000.00,\r\n    \"status\": \"active\",\r\n    \"bankId\": 6\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8082/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8082",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Update Account",
							"request": {
								"method": "PUT",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"accountNumber\": \"0000000005\",\r\n    \"accountType\": \"CORRIENTE\",\r\n    \"balance\": 75000.00,\r\n    \"status\": \"active\",\r\n    \"bankId\": 2\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8082/api/accounts",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8082",
									"path": [
										"api",
										"accounts"
									]
								}
							},
							"response": []
						},
						{
							"name": "Get Movements By accountNumber",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8082/api/accounts/movements/00000000001",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8082",
									"path": [
										"api",
										"accounts",
										"movements",
										"00000000001"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Transference",
					"item": [
						{
							"name": "Get Transferences",
							"request": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8083/api/transfer",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8083",
									"path": [
										"api",
										"transfer"
									]
								}
							},
							"response": []
						},
						{
							"name": "Make Transfer",
							"request": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"sourceAccountId\": \"00000000001\",\r\n    \"destinationAccountId\": \"00000000003\",\r\n    \"amount\": 10.00\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8083/api/transfer",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8083",
									"path": [
										"api",
										"transfer"
									]
								}
							},
							"response": []
						}
					]
				},
				{
					"name": "Register",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"username\": \"luisk\",\r\n    \"password\": \"123456\",\r\n    \"role\": \"ADMIN\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8085/api/auth/register",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8085",
							"path": [
								"api",
								"auth",
								"register"
							]
						}
					},
					"response": []
				},
				{
					"name": "Login",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"username\": \"luisk\",\r\n    \"password\": \"123456\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8085/api/auth/login",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8085",
							"path": [
								"api",
								"auth",
								"login"
							]
						}
					},
					"response": []
				}
			]
		}
	]
}
```