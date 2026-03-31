package com.shravan;

import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class ValidateEmailSchema {
  public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
    String schemaText = """
        {
          "type": "object",
          "properties": {
            "email": { "type": "string", "format": "email" }
          },
          "required": ["email"],
          "additionalProperties": false
        }
        """;

    String jsonText = """
        {"email":"user@example.com"}
        """;

    ObjectMapper mapper = new ObjectMapper();
    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
    JsonSchema schema = factory.getSchema(mapper.readTree(schemaText));
    JsonNode input = mapper.readTree(jsonText);

    Set<ValidationMessage> errors = schema.validate(input);
    if (errors.isEmpty()) {
      System.out.println("Valid email");
    } else {
      System.out.println("Invalid email:");
      errors.forEach(e -> System.out.println(e.getMessage()));
    }
  }
}
