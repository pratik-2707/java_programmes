import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  Question1 {

    public static List<String> getResponses(List<String> valid_auth_tokens, List<List<String>> requests) {
        List<String> responses = new ArrayList<>();

        // Define patterns for extracting tokens and parameters from URLs
        Pattern tokenPattern = Pattern.compile("token=([a-zA-Z0-9]{8,12})");
        Pattern paramsPattern = Pattern.compile("[&?]([^=]+)=([^&]+)");
        Pattern csrfPattern = Pattern.compile("csrf=([a-zA-Z0-9]{8,})");

        for (List<String> request : requests) {
            // Extract request method and URL
            String method = request.get(0);
            String url = request.get(1);

            // Check if the auth token is valid
            Matcher tokenMatcher = tokenPattern.matcher(url);
            String response = "INVALID";
            if (tokenMatcher.find()) {
                String authToken = tokenMatcher.group(1);
                if (valid_auth_tokens.contains(authToken)) {
                    // If method is POST, also check for CSRF token
                    if ("POST".equals(method)) {
                        Matcher csrfMatcher = csrfPattern.matcher(url);
                        if (csrfMatcher.find() && csrfMatcher.group(1).length() >= 8) {
                            response = "VALID";
                        }
                    } else {
                        response = "VALID";
                    }
                }
            }

            // If the request is valid, extract and append parameters
            if ("VALID".equals(response)) {
                Matcher paramsMatcher = paramsPattern.matcher(url);
                StringBuilder params = new StringBuilder(response);
                while (paramsMatcher.find()) {
                    params.append(",").append(paramsMatcher.group(1)).append("=").append(paramsMatcher.group(2));
                }
                response = params.toString();
            }

            responses.add(response);
        }

        return responses;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> validTokens = Arrays.asList("faH37j2ha483u", "safh34yw0bp5", "ba34wjyt8902");
        List<List<String>> reqs = Arrays.asList(
                Arrays.asList("GET", "https://example.com/?token=safh34yw0bp5&name=sam"),
                Arrays.asList("POST", "https://example.com/?token=safh34yw0bp5&csrf=ak2sh32dy&name=chris")
        );

        List<String> responses = getResponses(validTokens, reqs);
        for (String res : responses) {
            System.out.println(res) ;
       }
   }
}