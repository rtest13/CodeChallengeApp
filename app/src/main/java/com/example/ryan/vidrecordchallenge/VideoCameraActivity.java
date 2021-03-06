package com.example.ryan.vidrecordchallenge;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VideoCameraActivity extends AppCompatActivity {

    String[] perms = {"android.permission.RECORD_AUDIO", "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private Uri fileUri;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    public static VideoCameraActivity ActivityContext =null;
    public static TextView output;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_video_camera);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, VideoRecorderFragment.newInstance())
                    .commit();
        }
    }
//        Button buttonRecording = (Button)findViewById(R.id.recording);
//        output = (TextView)findViewById(R.id.output);
//
//        buttonRecording.setOnClickListener(new Button.OnClickListener(){
//
//            @Override
//            public void onClick(View arg0) {
//
//                // create new Intentwith with Standard Intent action that can be
//                // sent to have the camera application capture an video and return it.
//                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//
//                // create a file to save the video
//                fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
//
//                // set the image file name
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//
//                // set the video image quality to high
//                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
//
//                // start the Video Capture Intent
//                startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
//
//            }});
//
//
//    }
//
//    /** Create a file Uri for saving an image or video */
//    private static Uri getOutputMediaFileUri(int type){
//
//        return Uri.fromFile(getOutputMediaFile(type));
//    }
//
//    /** Create a File for saving an image or video */
//    private static File getOutputMediaFile(int type){
//
//        // Check that the SDCard is mounted
//        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), "MyCameraVideo");
//
//        // Create the storage directory(MyCameraVideo) if it does not exist
//        if (! mediaStorageDir.exists()){
//
//            if (! mediaStorageDir.mkdirs()){
//
//                output.setText("Failed to create directory MyCameraVideo.");
//
//                Toast.makeText(ActivityContext, "Failed to create directory MyCameraVideo.",
//                        Toast.LENGTH_LONG).show();
//
//                Log.d("MyCameraVideo", "Failed to create directory MyCameraVideo.");
//                return null;
//            }
//        }
//
//
//        // Create a media file name
//
//        // For unique file name appending current timeStamp with file name
//        java.util.Date date= new java.util.Date();
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//                .format(date.getTime());
//
//        File mediaFile;
//
//        if(type == MEDIA_TYPE_VIDEO) {
//
//            // For unique video file name appending current timeStamp with file name
//            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
//                    "VID_"+ timeStamp + ".mp4");
//
//        } else {
//            return null;
//        }
//
//        return mediaFile;
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        // After camera screen this code will excuted
//
//        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
//
//            if (resultCode == RESULT_OK) {
//
//                output.setText("Video File : " +data.getData());
//
//                // Video captured and saved to fileUri specified in the Intent
//                Toast.makeText(this, "Video saved to: " +
//                        data.getData(), Toast.LENGTH_LONG).show();
//
//            } else if (resultCode == RESULT_CANCELED) {
//
//                output.setText("User cancelled the video capture.");
//
//                // User cancelled the video capture
//                Toast.makeText(this, "User cancelled the video capture.",
//                        Toast.LENGTH_LONG).show();
//
//            } else {
//
//                output.setText("Video capture failed.");
//
//                // Video capture failed, advise user
//                Toast.makeText(this, "Video capture failed.",
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//    }

//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch(CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE){
//
//            case 200:
//                boolean audioAccepted = grantResults[0]==PackageManager.PERMISSION_GRANTED;
//                boolean cameraAccepted = grantResults[1]== PackageManager.PERMISSION_GRANTED;
//                boolean writeExternalStorageAccepted = grantResults[2]== PackageManager.PERMISSION_GRANTED;
//                break;
//
//        }
//
//    }


}