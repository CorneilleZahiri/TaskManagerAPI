package org.codewithcorneille.taskmanagerapi.task.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleEntityNotFound(EntityNotFoundException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(exception.getMessage()));
//    }

//    @ExceptionHandler(DataAlreadyExistsException.class)
//    public ResponseEntity<ApiResponse<Void>> handleDuplicateEntry(DataAlreadyExistsException exception) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(InvalidArgumentException.class)
//    public ResponseEntity<ApiResponse<Void>> handleInvalideArgument(InvalidArgumentException exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ApiResponse<Void>> handlerBadCredentialsException(BadCredentialsException exception) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(InvalidCredentialsException.class)
//    public ResponseEntity<ApiResponse<Void>> handleInvalideCredentials(InvalidCredentialsException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(TokenExpiredException.class)
//    public ResponseEntity<ApiResponse<Void>> handleExpiredToken(TokenExpiredException exception) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(InvalidTokenException.class)
//    public ResponseEntity<ApiResponse<Void>> handleInvalidToken(InvalidTokenException exception) {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(FileNotFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleFileNotFoundException(FileNotFoundException exception) {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(CompanyAccountContextMissingException.class)
//    public ResponseEntity<ApiResponse<Void>> handleCompanyAccountContextMissingException(
//            CompanyAccountContextMissingException exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ApiResponse<Void>> handleIllegalArgumentException(IllegalArgumentException exception) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(exception.getMessage()));
//    }
//
//    // 404 route inexistante
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ApiResponse<Void>> handleNotFound(NoHandlerFoundException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("La route demandée n'existe pas"));
//    }
//
//    // 405 mauvais verbe HTTP
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ApiResponse<Void>> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
//        String method = ex.getMethod();
//
//        String supported = (ex.getSupportedHttpMethods() != null)
//                ? ex.getSupportedHttpMethods().stream()
//                .map(HttpMethod::name)
//                .collect(Collectors.joining(", ")) : "inconnues";
//
//        String message = "La méthode HTTP '" + method + "' n'est pas autorisée pour cette route. " +
//                "Méthodes supportées : " + supported;
//
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(ApiResponse.error(message));
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<ApiResponse<Void>> handleTypeMismatch(
//            MethodArgumentTypeMismatchException ex
//    ) {
//        String field = ex.getName();
//        String value = ex.getValue() != null ? ex.getValue().toString() : "null";
//
//        String message = "Valeur invalide pour le paramètre '" + field + "' : '" + value + "'";
//
//        return ResponseEntity.badRequest().body(ApiResponse.error(message));
//    }
//
//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public ResponseEntity<ApiResponse<Void>> handleMaxSizeExceeded(MaxUploadSizeExceededException e) {
//        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
//                .body(ApiResponse.error("La taille des fichiers dépasse la limite autorisée"));
//    }
}
