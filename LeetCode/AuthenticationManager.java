import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        authenticationManager.countUnexpiredTokens(6);
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        authenticationManager.countUnexpiredTokens(15);
    }
}

class AuthenticationManager {

    private int timeToLive;
    private HashMap<String, Token> tokens = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        int expirationTime = timeToLive + currentTime;
        Token token = new Token(expirationTime);
        tokens.put(tokenId, token);
    }
    
    public void renew(String tokenId, int currentTime) {
        Token token = tokens.get(tokenId);
        if(token == null)
            return;
        if(!token.hasExpired(currentTime)){
            int newExpirationTime = currentTime + timeToLive;
            token.expirationTime = newExpirationTime;
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(String tokenId: tokens.keySet()) {
            Token token = tokens.get(tokenId);
            if(!token.hasExpired(currentTime))
                count++;
        }
        return count;
    }

    class Token {
        int expirationTime;

        public Token(int expirationTime){
            this.expirationTime = expirationTime;
        }

        boolean hasExpired(int currentTime){
            return expirationTime <= currentTime;
        }
    }
}
