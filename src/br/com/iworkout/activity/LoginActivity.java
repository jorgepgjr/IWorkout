package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import java.util.Arrays;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.User;
//import br.com.iworkout.util.FacebookUtil;


public class LoginActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";
    private User usuario;
    private SharedPreferences settings;
    private LoginButton authButton;
    private UiLifecycleHelper uiHelper;
    private String  path;
//    private FacebookUtil fbUtil = new FacebookUtil(this);
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        path = this.getFilesDir().getAbsolutePath();
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        authButton = (LoginButton) findViewById(R.id.authButton);
        authButton.setReadPermissions(Arrays.asList("user_location", "user_birthday", "user_likes"));
    }

    //FACEBOOK
    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.i("LoginActivity", "Logged in...");
            // make request to the /me API
            Request.newMeRequest(session, new Request.GraphUserCallback() {

                // callback after Graph API response with user object
                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if (user != null) {
                        //TODO: verifica se já temos esse usuário cadastrado apartir do ID do FB
                        try {
//                            fbUtil.execute(user.getId());
//                            FileOutputStream out;
//                            out = openFileOutput("user_profile_img", Context.MODE_PRIVATE);
//                            URL img_value = new URL("http://graph.facebook.com/"+user.getId()+"/picture?type=large");
//                            Bitmap mIcon1 = BitmapFactory.decodeStream(img_value.openConnection().getInputStream());
//                            mIcon1.compress(Bitmap.CompressFormat.PNG, 90, out);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        user.getId();
                        User usuario = new User();
                        usuario.setNome(user.getName());
//                        usuario.setDataNascimento(user.getBirthday());
                    }
                }
            }).executeAsync();
            //TODO: Se já estiver logado pelo FB redirecionar para a tela de menu direto;

        } else if (state.isClosed()) {
            Log.i("LoginActivity", "Logged out...");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    public void logar(View view) {
        //TODO: regra de login
        //TODO: Verifica se já tem metricas definidas se não tiver manda pra tela de metricas:
        Intent intent = new Intent(this, MetricsActivity.class);
        startActivity(intent);
//        Intent intent = new Intent(this, MenuActivity.class);
//        startActivity(intent);
        finish();
    }


    //Obrigatório sobrescrever para usar o Helper de life cycle do FACEBOOK
    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
//        Session session = Session.getActiveSession();
//        if (session != null &&
//                (session.isOpened() || session.isClosed()) ) {
//            onSessionStateChange(session, session.getState(), null);
//        }

        uiHelper.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }
}

