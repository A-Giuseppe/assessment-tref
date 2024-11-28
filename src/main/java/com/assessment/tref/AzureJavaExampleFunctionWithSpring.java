package com.assessment.tref;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class AzureJavaExampleFunctionWithSpring {
    private final Function<String, String> uppercase;

    public AzureJavaExampleFunctionWithSpring(Function<String, String> uppercase) {
        this.uppercase = uppercase;
    }

    @FunctionName("bean")
    public String plainBeans(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> requestMessage, ExecutionContext context){

        return uppercase.apply(requestMessage.getBody().orElse("DefaultHelloWorld"));
    }
}
