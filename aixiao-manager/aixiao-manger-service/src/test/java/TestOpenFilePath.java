import org.junit.Test;

import javax.swing.*;
import java.io.File;

/**
 * @author djb
 * @create 2019-05-26 13:48
 */
public class TestOpenFilePath {

    @Test
    public void test1(){
        /*OpenFileDialog openFileDialog = new OpenFileDialog();

        openFileDialog.InitialDirectory = Environment.GetFolderPath(Environment.SpecialFolder.Desktop);

        DialogResult dr = openFileDialog.ShowDialog();*/
    }

    @Test
    public void test2(){
        JFileChooser jf = new JFileChooser();
        //       设置 JFileChooser，以允许用户只选择文件、只选择目录，或者可选择文件和目录。
        //
        //mode参数：FILES_AND_DIRECTORIES   指示显示文件和目录。
        //
        //      FILES_ONLY                             指示仅显示文件。
        //
        //     DIRECTORIES_ONLY                指示仅显示目录。
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.setSelectedFile(new File("c:\\我的报表.xls"));
        int value = jf.showSaveDialog(null);
        jf.setFileHidingEnabled(false);
        if (value == JFileChooser.APPROVE_OPTION) {
            File getPath = jf.getSelectedFile();
            System.out.println(getPath);
            // TODO
        } else {
            // TODO
        }
    }

}
