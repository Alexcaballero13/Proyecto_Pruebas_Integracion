# Registro de Defectos - Proyecto Integrador

## Defecto 01 — HTTP 500 por género inválido (Sistema)

- **Caso de prueba:** POST `/register` con `gender: "OTHER"`
- **Entrada:** `{"name":"Laura","id":500,"age":20,"gender":"OTHER","alive":true}`
- **Resultado esperado:** HTTP 400 (Bad Request)
- **Resultado obtenido:** HTTP 500 (Internal Server Error) — antes de implementar `GlobalExceptionHandler`
- **Causa probable:** `Gender.valueOf()` lanzaba excepción no manejada en el controlador.
- **Tipo:** Sistema (REST)
- **Estado:** Resuelto
- **Evidencia:** `RegistryControllerIT.shouldReturnBadRequestForInvalidGender` pasa tras agregar `@RestControllerAdvice`.

## Tabla resumen

| ID | Capa | Tipo | Esperado | Obtenido | Estado |
|----|------|------|----------|----------|--------|
| 01 | Delivery | Sistema | HTTP 400 | HTTP 500 | Resuelto |
