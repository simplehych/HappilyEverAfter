package com.simple.commonlibrary.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by hych on 2017/4/12.
 */
public class PermissionsUtils {

    public static String[] XunFeiNeedPermissions = {Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE};
    public static String[] StorageNeedPermissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public static String[] LocaledNeedPermissions = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    public static String[] CameraWithStoragePermissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public static String[] GetIMEINeedPermissions = {Manifest.permission.READ_PHONE_STATE};
    public static String[] FileSaveNeedPermissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public static String[] FileAndIMEINeedPermissions = {Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public static String[] CameraNeedPermissions = {Manifest.permission.CAMERA};
    public static final int GETIMEI_REQUEST_CODE = 3000;
    public static final int REQUEST_PERMISSION_WRTTING_SETTING = 3001; //设置权限 某些第三方sdk 需要此权限
    public static final int REQUEST_PERMISSION_SYS_ALERT_WINDOW = 3002;

    /**
     * 支持讯飞的权限
     *
     * @param activity
     * @param action
     */
    public static void requestXunFeiNeedPermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, XunFeiNeedPermissions, action);

    }

    /**
     * 使用内存的权限
     *
     * @param activity
     * @param action
     */
    public static void requestStorageNeedPermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, StorageNeedPermissions, action);

    }

    /**
     * 获取位置信息的权限
     *
     * @param activity
     * @param action
     */
    public static void requestLocaledNeedPermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, LocaledNeedPermissions, action);

    }

    /**
     * 使用相机权限 需要存储功能支持
     *
     * @param activity
     * @param action
     */
    public static void requestCameraWithStoragePermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, CameraWithStoragePermissions, action);

    }

    /**
     * 使用相机权限
     *
     * @param activity
     * @param action
     */
    public static void requestCameraPermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, CameraNeedPermissions, action);

    }

    /**
     * 读取手机状态权限
     *
     * @param activity
     * @param action
     */
    public static void requestGetIMEINeedPermissions(final @Nullable Activity activity, final @Nullable PermissionsResultAction action) {

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, GetIMEINeedPermissions, action);

    }


    /**
     * 判断权限是否授权
     *
     * @param activity
     * @param permissions
     * @return
     */
    public static boolean checkPermission(final @Nullable Activity activity, final @Nullable String[] permissions) {
        return PermissionsManager.getInstance().hasAllPermissions(activity, permissions);
    }


    /**
     * 授权不指定的权限
     *
     * @param activity
     * @param permissions
     * @param action
     */
    public static void requestPermission(final @Nullable Activity activity, final @Nullable String[] permissions, final @Nullable PermissionsResultAction action) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, permissions, action);
    }

    /**
     * 取授权结果
     *
     * @param permissions
     * @param grantResults
     */
    public static void permissionsGrantResultsNotify(@NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
    }

    public static boolean checkWriteSettingPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(activity)) {
            return false;
        } else {
            return true;
        }

    }

    public static void requestWriteSettingPermission(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivityForResult(intent, REQUEST_PERMISSION_WRTTING_SETTING);
    }

    public static boolean checkAlertWindowPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(activity)) {
            return false;
        } else {
            return true;
        }
    }

    public static void requestAlertWindowPermission(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivityForResult(intent, REQUEST_PERMISSION_SYS_ALERT_WINDOW);
    }

}
