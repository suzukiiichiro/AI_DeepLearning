import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleFunction;


public class DeepLearning {
	public static void main(String[] args) {
/**
  * ****************************************************
  * Javaで学ぶニューラルネットワークとディープラーニング
  * 一般社団法人 共同通信社　suzuki.iichiro@kyodonews.jp
  * 
  * １．ニューラルネットワーク ←
  * ２．ディープニューラルネットワーク
  * 
  * ****************************************************
  * 
  * ディープラーニングはニューラルネットワークを応用したもの。
  * ニューラルネットワークは人間の脳をまねた機械学習アルゴリズム。
  * ディープラーニングとは、「機械自らが与えられたデータの中から、特徴量を見つ
  * け出し、学習する」事。
  * 
  * １９５０年代後半第一次人工知能ブーム
  * 人間が定義した決められたルールに基づいた探索プログラム
  *   深さ優先探索・幅優先探索
  * 膨大な数の勝ち負けのパターン、過去の戦いのデータ、駒の許容異動は二などをあらか
  * じめ機械に入力しておく。機械は駒の配置を読み取り、膨大な数のパターンの中から次
  * のベストな一手を決めることができる。チェスや将棋などでは一定の成果を上げること
  * ができた。
  * 
  * できないこと
  * 無数のパターンの中から、関係のない選択肢を切り捨てること。
  * →フレーム問題
  * 
  * １９８０年代第二次人工知能ブーム
  * もし機械に世界のあらゆる知識が集約され、機械がその知識を理解すれば、どんな複雑
  * な問題が与えられても機械が正しい答えを導き出してくれるはずだ。 あらかじめ定義さ
  * れた辞書を機械に入力しておけば、機械がその文章と辞書を照らし合わせ、人間の問い
  * に機械が反応し答えることができる。
  * 
  * できないこと
  * 現実世界の知識全てを定義することはできない。 機械は知っている問題に対しては素早
  * く対応できたが、知らない問題に出会うとても足も出なかった。
  *   →推論の限界 機械は本当の意味を理解しているわけではない
  * 　→シンボルグラウンディング
  * 
  * ２０００年第三次人工知能ブーム
  * 確率・統計モデルに基づくパターン認識と分類
  * 機械の高い計算力及び高速処理能力を武器に大量のトレーニングデータを使い複雑な問
  * 題をYes/Noに置き換えた上で、どんなデータがYesなのか、またどんなデータがNoなのか
  * について規則性（パターン）を見つけ出し学習し分類した。
  * 
  * できないこと
  * 機械学習のパターンモデルパラメータといった特徴量設計。
  * 人間の勘やセンスにたより。膨大で細かいパラメータ調整に明け暮れる。
  * 
  * ・フレーム問題
  * ある課題が機械に与えられたときに、どの知識を使うべきか機械が認識できない。
  * 
  * ・シンボルグラウンディング
  * 機械が知識を記号としてしか認識していないために、知識を組み合わせた概念を機械が
  * 理解できない。
  * 
  * ・特徴量設計
  * 機械が対象物の何が特徴なのか判らない。
  * 
  * →　機械が「ある事象のどの特徴に注目して、どのような情報を使えばよいのか」がわか
  * れば解決できる。
  * 
  * →→機械が与えられたデータから特徴を抽出し、
  *   その特徴に基づいたどの知識を使うべきかを判断し(フレーム問題解決）
  *   その知識を組み合わせた概念を理解し(シンボルグラウンディング解決）
  *   状況や目的に合わせて適切な知識を自ら取得し解決できる。
  * 
  * ２００６年第四次人工知能ブーム
  * 
  *   ディープラーニング
  *   機械が与えられたデータから何が重要な特徴量であるかを見つけ出す手法
  * 
  *   プレトレーニング
  * 　ニューラルネットワーク時代　
  * 　学習時に発生した誤差をネットワーク全体にフィードバックする。層が積み重なった
  * ネットワークでは、誤差が消えてしまう。幾重にも積み重ねられた層のネットワーク全
  * 体を一つの巨大なニューラルネットワークとして、一度に学習させようとしたため。
  * 
  * 　ディープラーニング時代
  *   次元の低い層の特徴を学習し、次の層の入力データとして扱う。おおよその全体像を
  *   つかんでから細部の特徴を次の層で学習する。
  * 
  *   ドロップアウト
  * 　ネットワーク内のいくつかのつながりをランダムに切断し学習する。これにより学習
  * のステップごとに違うネットワークが形成され、ネットワークの重みの調整がうまくい
  * く。
  * 
  * できないこと
  * 学習が完了するまでのステップが長い。途方もないリソースが必要。
  * Googleの猫　１０００台で３日
  * 
  * =====================================================================
  * 機械学習による分離
  * 
  * ２種類のデータには、二つを分ける境界線がありそうだ。
  * 境界線をどこに奥かを決めればよい。
  * では早速境界線を決めよう。→　実際には明確に境界線を定義することは難しい
  * 
  * 線形分離　データ群を直線で分離することができる場合
  * 非線形分離　データ群を直線では分離できない場合
  * 
  * 機械学習により決定される境界を識別境界といい、直線か非直線をか問わない
  * 
  * SVM(Support Vector Machine)
  * 分類する各グループ間の距離が最大となるような識別境界を求める手法
  * どのグループからも距離が最も大きい真ん中を識別境界に置く。
  *   →マージン最大化
  */

/**
 * １．ニューラルネットワーク
 * 
 * 		単層ニューラルネットワーク
 * 			1. パーセプトロン
 * 			2. ロジスティック回帰
 * 			3. 多クラスロジスティック回帰
 *		多層ニューラルネットワーク
 *			4. 多層ニューラルネットワーク
 *
 *
 *  	単層ニューラルネットワークの問題点
 *  		非線形問題を解くことができない
 *  
 *  	入力層と出力層の間に隠れ層を加えた、多層ニューラルネットワークで解決できる。
 *  	なぜ、多層ニューラルネットワークが非線形問題を解くことができるのか。
 * 			→　できる
 *  
 *  	１．ユニットを増やすことでより複雑な関数を揚言する能力を持てるようになったから
 *  	２．モデルが非線形問題も解くことができるようになるための鍵は、
 * 	 		バックプロパゲーションアルゴリズム。
 *  		出力の誤差をネットワーク全体に逆伝播することで、
 *  		各反復でモデルがトレーニングデータに適合するよう更新され、
 *  		最終的にデータの関数に近似するよう最適化される。
 * 
 */

		/**
		 * １．ニューラルネットワーク 
		 * 
		 * パーセプトロン ステップ関数 
		 * パーセプトロンは、ニューラルネットワークのアルゴリズムの中でも
		 * 最も単純な作りをしたモデルであり、二つのクラスを線形識別できる 
		 * モデルでニューラルネットワークの原型でもある。
		 * データセットが線形に分けられることが保証されている場合、アルゴリズムの精
		 * 度は学習率の値とは無関係であるため、学習率の値は１でよい。
		 */
//		Perceptrons pt = new Perceptrons(2);
//		pt.setDataSet(); // データセット
//		pt.buildModel(); // モデルの構築
//		pt.evaluetion(); // 評価テスト
		/**
		 * ロジスティック回帰 シグモイド関数
		 * 連続値を取る二つの変数からなる式を想定した回帰モデルで、
		 * パーセプトロンを一般化した線形分離モデルで、ニューラルネットワーク の一
		 * つである。
		 * パーセプトロンでは、活性化関数にステップ関数を用いているが、 ロジスティッ
		 * ク回帰では、シグモイド関数を用いている。
			 * シグモイド関数は、任意の実数を０から１の値に写像する。
		 * つまりロジ スティック回帰の出力は、それぞれのクラスの事後確率と見なすこ
		 * とができる。
		 */
//		LogisticRegression lr = new LogisticRegression(2, 3);
//		lr.setDataSet();
//		lr.buildLogisticRegressionModel();
//		lr.evaluate();
//		lr.print();
		/**
		 * 多クラスロジスティック回帰 ソフトマックス関数
		 * ロジスティック回帰は多クラス分類にも応用することができる。
		 * 2クラス分類では、活性化関数がシグモイド関数であり、出力が０から１になる
		 * ことで、データがどちらのクラスに所属する確率が高いかを求めることができた。
		 * クラス数がＫのときは、各クラスの所属度を表す確立ベクトル（出力がＫ次元）と 
		 * することで多クラスデータも分類できる。
		 * シグモイド関数の多変量版であるソフトマックス関数を用いる。
		 */
//		LogisticRegressionXOR lrXOR = new LogisticRegressionXOR(2, 3);
//		lrXOR.setDataSet();
//		lrXOR.buildLogisticRegressionModel();
//		lrXOR.print();
		/**
		 * 多層パーセプトロン（多層ニューラルネットワーク）
		 * 単層ニューラルネットワークには大きな問題があった。
		 * 線形分離できる問題には効率的なパーセプトロンやロジスティック回帰であるが、
		 * 非線形問題を全く解くことができないのである。
		 * 最も単純なXOR（排他的論理和問題）でさえとくことができない。
		 * 現実問題のほとんどは非線形であるため、パーセプトロンやロジスティック回帰
		 * では実用性がない。
		 * そこで非線形の問題にも対応できるようにアルゴリズムを改良したものが、
		 * 多層ニューラスネットワークである。
		 * 入力層と出力層の間に「隠れ層」と呼ばれる層を加えることで、
		 * ネットワークが様々なパターンを表現できるようにした。
		 * 個々で重要なのは、隠れ層を飛び越えた入力層と出力層の直結を導入せず、
		 * 必ず、フィードフォワードネットワークの構造にしておくこと。
		 * こうすることで、隠れ層の数が多くなろうとも、数学的に複雑になりすぎずに、
		 * 任意の関数を近似することができる。
		 * 隠れ層にはHiddenLayerクラス、出力層にはLogisticRegressionクラスが定義されている。
		 * 出力の誤差をネットワーク全体に逆伝播することにより、各反復でモデルがトレー
		 * ニングデータに適合するよう更新されるバックプロパゲーションが鍵となる。
		 */
//		MultiLayerPerceptrons mlpt = new MultiLayerPerceptrons(2, 3, 2, new Random(123));
//		mlpt.setDataSet();
//		mlpt.buildMultiLayerPerceptronsModel();
//		mlpt.evaluate();
//		mlpt.print();
		
/**
  * ****************************************************
  * Javaで学ぶニューラルネットワークとディープラーニング
  * 一般社団法人 共同通信社　suzuki.iichiro@kyodonews.jp
  * 
  * １．ニューラルネットワーク
  * ２．ディープニューラルネットワーク ←
  * 
  * ****************************************************
  * 
  *  前項からのあらすじ
  *  パーセプトロンでは解決できなかった非線形分類も、多層ニューラルネットワークで
  *  すなわち、入力層と出力層の間に隠れ層を追加することで、学習することができた。
  *  
  *  理由
  *  ニューロンの数が増えることで、ニューラルネットワーク全体で表現できるパターンが
  *  増えたから。
  *  
  *  では、隠れ層の数をもっと増やせば。隠れ層をもっと積み重ねれば、どんなに複雑な
  *  問題でも解決できるのではないか。
  *  →この試みはうまくいかなかった。
  *  単純に層を積み重ねるだけでは逆に、層の数が少ないものより予測の精度が下がってしまう。
  *  
  *  なぜ。
  *  フィードフォワードネットワークが持つ特徴に原因があった。
  *  多層ニューラルネットワークで効率的に学習誤差をネットワーク全体に伝播するには、
  *  バックプロパゲーションアルゴリズムが用いられる。このアルゴリズムでは、
  *  誤差はニューラルネットワークの各層を逆順に、一層ずつ順番に入力層まで辿る。
  *  出力層での誤差を入力層まで逆伝播することで、隠そうごとに順番にネットワークの重みが
  *  調整され、ネットワーク全体の重みが最適化される。層の数が多くなったときには、
  *  層をさかのぼるごとに誤差が次第に消えて行ってしまい、ネットワークの重みを調整できない。
  *  入力層に近いそうでは、誤差が全くフィードバックされなくなってしまったのだ。
  *  
  *  層と層の間が密につながったニューラルネットワークには、重みを調整する機能が欠如して
  *  しまっていた。この問題を、勾配消失問題という。
  *  
  *  ディープラーニングではこの問題は起きない。なぜか。
  *  
  *  １．ディープビリーフネット
  *  ２．積層デノイジング・オートエンコーダ
  *  
  *  上記二つのアルゴリズムによって、深層にもかかわらず高い予測精度を記録した。
  *  この二つのアルゴリズムに共通する、勾配消失問題を解決した手法とは何か。
  *  
  *  レイヤーワイズトレーニング   各層ごとに学習をするという手法。
  *  これにより、各層がそれぞれ独立してネットワークの重みを調整するため、
  *  層が幾重に積み重なったも、ネットワーク全体（すなわちモデルのパラメータ）が適切に最適化
  *  されるようになった。
  *  
  *  ニューラルネットワークでは、ユニット数や層の数が多いほど、理論上は表現力が増え、
  *  解くことができる問題も増える。それがうまくいかなかったのは、誤差を各層に正しくフィードバックできず、
  *  ネットワーク全体としてのパラメータを適切に調整できなかったからだ。
  *  
  *  ディープラーニングでは、レイヤーワイズトレーニングにより、
  *  各層がそれぞれ独立してネットワークの重みを調整するため、層が幾重に積み重なっても、
  *  ネットワーク全体（すなわちモデルのパラメータ）が適切に最適化されるようになった。
  *  
  *  「出力層で発生した誤差を入力層まで行きに逆伝播して学習しようとしたらうまくいかなかったので、
  *  各層ごとに分けて学習を行い、誤差を層ごとにすぐに反映させることでうまくいくようになった」
  *  
  *  レイヤーワイズトレーニングのテクニック
  *  ・プレトレーニング（事前学習 各層ごとの学習）
  *  ・ファインチューニング（微調整 ネットワーク全体に対する調整）
  *  
  *  「前後の層がともに隠れそうでは、入力層も出力層もないが、どのように学習すればよいのだろう。
  *  何が入力になり、そしてどのように出力すればよいのだろう」
  *  
  *  ニューラルネットワークでは、入力層と隠れ層、隠れ層と出力層の間で、ネットワークパラメータ
  *  重みとバイアスを調整する必要があった。
  *  ディープラーニングでは、加えて、隠れ層と隠れ層の間でも重みとバイヤスの調整が必要である。
  *  
  *  入力について
  *  	前の層から伝播してきた値がそのまま入力になる。
  *  	前の層から伝播してきた値とは、ネットワークの重みを用いて前の層から現在の層まで順伝播してきた値。
  *  	→	一つ以上前の層が学習した特徴が現在の層の入力となり、
  *  		現在の層は底から亜新たに与えられたデータの特徴を学び取る
  *  		→　入力データから段階的に特徴を学び取っていく
  *  			→　層がより深くなるほど、より高次な特徴を学習する
  * 	「機械が概念を学び取れるようになった」
  * 
  * 出力について
  * 	ディープビリーフネットと積層デノイジング・オートエンコーダともに、次の条件を満たすように学習をする。
  * 	「出力値と入力値と同じになるように学習する」
  * 	→　入力層から入ってきた値は、隠れ層を通ってまた入力層に戻る。
  * 		その時の誤差がなくなるように（すなわち出力値と入力値が一致するように）ネットワークの重みを調整する。
  *			 
  * ファインチューニング
  * 	役割
  * 
  * 	1. 出力層手前までの各層に対してプレトレーニングが終了したら、
  * 	出力層を加えたニューラルネットワーク全体に対してトレーニングデータで教師有り学習を行う。
  * 	「出力層における教師有り学習には、
  * 		計算量と得られる精度とのバランスからロジスティック回帰を用いることが多い。」
  * 	2. ディープニューラルネットワーク全体の重みの最終調整を行う。
  *		「すなわちバックプロパゲーションアルゴリズム」が適用される。	
  * 
  * 	勾配消失問題は発生しないのか？
  *		プレトレーニングを挟んだ場合、ネットワークの重みはプレトレーニングによってほぼ調整された状態になり、
  *		その後で学習が行われる。そのため適切な誤差が入力層に近い層まできちんと伝播する。
  * 
  *	ディープラーニング
  *		プレトレーニングでは、モデルのパラメータは層ごとに最適化され、
  *		ファインチューニングで一つのディープニューラルネットワークとして調整される。
  *
  * 
  * ディープラーニングのアルゴリズム
  * 		
  *  １．ディープビリーフネット
  *  	プレトレーニング (制約つきボルツマンマシン）
  *  	ファインチューニング
  *  ２．積層デノイジング・オートエンコーダ
  *  	プレトレーニング
  *  	ファインチューニング
  *
  *  制約つきボルツマンマシン
  *  他の全てのユニットと結合したネットワーク
  * 
  */
        RestrictedBoltzmannMachines RBM = new RestrictedBoltzmannMachines();
        RBM.setDataSet();
        RBM.buildBoltzmannMachinesModel();
        RBM.evaluate();
	}
}
class RestrictedBoltzmannMachines {
    public int nVisible;
    public int nHidden;
    public double[][] W;
    public double[] hbias;
    public double[] vbias;
    public Random rng;
	int train_N_each;         // for demo
	int test_N_each ;            // for demo
	int nVisible_each ;          // for demo
	double pNoise_Training;  // for demo
	double pNoise_Test;      // for demo
	int patterns;
	int train_N ;
	int test_N ;
	int[][] train_X ;
	int[][] test_X ;
	double[][] reconstructed_X ;
	int epochs ;
	double learningRate ;
	int minibatchSize;
	int minibatch_N ;
	int[][][] train_X_minibatch ;
	List<Integer> minibatchIndex ;
	public RestrictedBoltzmannMachines(){
		rng = new Random(123);
		train_N_each = 200;         // for demo
		test_N_each = 2;            // for demo
		nVisible_each = 4;          // for demo
		pNoise_Training = 0.05;  // for demo
		pNoise_Test = 0.25;      // for demo
		patterns = 3;
		train_N = train_N_each * patterns;
		test_N = test_N_each * patterns;
		nVisible = nVisible_each * patterns;
		nHidden = 6;
		train_X = new int[train_N][nVisible];
		test_X = new int[test_N][nVisible];
		reconstructed_X = new double[test_N][nVisible];
		epochs = 1000;
		learningRate = 0.2;
		minibatchSize = 10;
		minibatch_N = train_N / minibatchSize;
		train_X_minibatch = new int[minibatch_N][minibatchSize][nVisible];
		minibatchIndex = new ArrayList<>();
		for (int i = 0; i < train_N; i++) {
			minibatchIndex.add(i);
		}
		Collections.shuffle(minibatchIndex, rng);
	}
    public RestrictedBoltzmannMachines(int nVisible, int nHidden, double[][] W, double[] hbias, double[] vbias, Random rng) {
        if (rng == null) rng = new Random(1234);  // seed random
        if (W == null) {
        	// 隠れ層と可視層の数をサイズとする二次元配列
            W = new double[nHidden][nVisible];
            // 1を可視層の数で割った値（重みの初期化に用いる）
            double w_ = 1. / nVisible;
            for (int j = 0; j < nHidden; j++) {
                for (int i = 0; i < nVisible; i++) {
                	// (-w_, w_)間の一様分布に従う乱数を用いて重みの初期化を行う
                    W[j][i] = RandomGenerator.uniform(-w_, w_, rng);
                }
            }
        }
        // hbiasがnullの場合、hbiasを配列として初期化
        if (hbias == null) {
            hbias = new double[nHidden];
            // biasの初期値は0
            for (int j = 0; j < nHidden; j++) {
                hbias[j] = 0.;
            }
        }
        // vbiasがnullの場合、vbiasを配列として初期化
        if (vbias == null) {
            vbias = new double[nVisible];
            // vbiasの初期値は0
            for (int i = 0; i < nVisible; i++) {
                vbias[i] = 0.;
            }
        }
        this.nVisible = nVisible;
        this.nHidden = nHidden;
        this.W = W;
        this.hbias = hbias;
        this.vbias = vbias;
        this.rng = rng;
    }

    /**
     * 制約つきボルツマンマシンの肝
     * CD-1で充分中井が得られるのだが、このメソッドではCD-kに対応できるようになっている
     */
    public void contrastiveDivergence(int[][] X, int minibatchSize, double learningRate, int k) {
        double[][] grad_W = new double[nHidden][nVisible];
        double[] grad_hbias = new double[nHidden];
        double[] grad_vbias = new double[nVisible];
        for (int n = 0; n < minibatchSize; n++) {
            double[] phMean_ = new double[nHidden];
            int[] phSample_ = new int[nHidden];
            double[] nvMeans_ = new double[nVisible];
            int[] nvSamples_ = new int[nVisible];
            double[] nhMeans_ = new double[nHidden];
            int[] nhSamples_ = new int[nHidden];
            // CD-kのサンプリング : (実際はk=1のCD-1 で充分)
            sampleHgivenV(X[n], phMean_, phSample_);
            for (int step = 0; step < k; step++) {
                // ギブスサンプリング
                if (step == 0) {
                    gibbsHVH(phSample_, nvMeans_, nvSamples_, nhMeans_, nhSamples_);
                } else {
                    gibbsHVH(nhSamples_, nvMeans_, nvSamples_, nhMeans_, nhSamples_);
                }
            }
            // 勾配を計算
            for (int j = 0; j < nHidden; j++) {
                for (int i = 0; i < nVisible; i++) {
                    grad_W[j][i] += phMean_[j] * X[n][i] - nhMeans_[j] * nvSamples_[i];
                }
                grad_hbias[j] += phMean_[j] - nhMeans_[j];
            }
            for (int i = 0; i < nVisible; i++) {
                grad_vbias[i] += X[n][i] - nvSamples_[i];
            }
        }
        // パラメータ更新
        for (int j = 0; j < nHidden; j++) {
            for (int i = 0; i < nVisible; i++) {
            	// ミニバッチ単位で勾配を求めているため、更新の際は
            	// ミニバッチが持つデータ数で勾配の総和を割る必要がある
                W[j][i] += learningRate * grad_W[j][i] / minibatchSize;
            }
            hbias[j] += learningRate * grad_hbias[j] / minibatchSize;
        }
        for (int i = 0; i < nVisible; i++) {
            vbias[i] += learningRate * grad_vbias[i] / minibatchSize;
        }
    }

    /**
     * CD-kはサンプリングのための二つのメソッドsampleVgivenHとsampleHgivenVで成り立っている
     */
    public void gibbsHVH(int[] h0Sample, double[] nvMeans, int[] nvSamples, double[] nhMeans, int[] nhSamples) {
        sampleVgivenH(h0Sample, nvMeans, nvSamples);
        sampleHgivenV(nvSamples, nhMeans, nhSamples);
    }
    /**
     * sampleHgivenVは
     * 可視ユニットの与えられた値を元に隠れ層で生成される確率分布及びサンプリングデータを設定するメソッド
     */
    public void sampleHgivenV(int[] v0Sample, double[] mean, int[] sample) {
        for (int j = 0; j < nHidden; j++) {
        	/**
        	 * propupは可視層から隠れ層への活性
        	 * binomialは二項分布（結果が二つに分かれる場合の確率分布）に基づいて０または１の値を返す
        	 * 		このメソッドを通して各ユニットの値はバイナリとなる
        	 */
            mean[j] = propup(v0Sample, W[j], hbias[j]);
            sample[j] = RandomGenerator.binomial(1, mean[j], rng);
        }
    }
    /**
     * sampleVgivenHは
     * 隠れユニットの値を元に、サンプリングデータの設定を行う。
     */
    public void sampleVgivenH(int[] h0Sample, double[] mean, int[] sample) {
        for(int i = 0; i < nVisible; i++) {
        	/**
        	 * propdownは隠れ層から可視層への活性
        	 * binomialは二項分布（結果が二つに分かれる場合の確率分布）に基づいて０または１の値を返す
        	 * 		このメソッドを通して各ユニットの値はバイナリとなる
        	 */
            mean[i] = propdown(h0Sample, i, vbias[i]);
            sample[i] = RandomGenerator.binomial(1, mean[i], rng);
        }
    }
    /**
     * propdownは隠れ層から可視層への活性
     */
    public double propup(int[] v, double[] w, double bias) {
        double preActivation = 0.;
        for (int i = 0; i < nVisible; i++) {
            preActivation += w[i] * v[i];
        }
        preActivation += bias;
        return ActivationFunction.sigmoid(preActivation);
    }

	/**
	 * propupは可視層から隠れ層への活性
	 */
    public double propdown(int[] h, int i, double bias) {
        double preActivation = 0.;
        for (int j = 0; j < nHidden; j++) {
            preActivation += W[j][i] * h[j];
        }
        preActivation += bias;

        return ActivationFunction.sigmoid(preActivation);
    }

    /**
     * 学習済みの制約つきボルツマンマシンは重みが調整されたニューラルネットワークであるため、
     * ネットワークを通じて単純に入力データ（素縄立ちの伊豆を含むデータ）を伝播させれば、
     * ノイズが取り除かれたデータが生成される。
     */
    public double[] reconstruct(int[] v) {
        double[] x = new double[nVisible];
        double[] h = new double[nHidden];
        for (int j = 0; j < nHidden; j++) {
            h[j] = propup(v, W[j], hbias[j]);
        }
        for (int i = 0; i < nVisible; i++) {
            double preActivation_ = 0.;
            for (int j = 0; j < nHidden; j++) {
                preActivation_ += W[j][i] * h[j];
            }
            preActivation_ += vbias[i];
            x[i] = ActivationFunction.sigmoid(preActivation_);
        }
        return x;
    }
    /**
     * データセットのセット
     */
    public void setDataSet(){
        //
        // Create training data and test data for demo.
        //   Data without noise would be:
        //     class 1 : [1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
        //     class 2 : [0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0]
        //     class 3 : [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1]
        //   and to each data, we add some noise.
        //   For example, one of the data in class 1 could be:
        //     [1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1]
        //
        for (int pattern = 0; pattern < patterns; pattern++) {
            for (int n = 0; n < train_N_each; n++) {
                int n_ = pattern * train_N_each + n;
                for (int i = 0; i < nVisible; i++) {
                    if ( (n_ >= train_N_each * pattern && n_ < train_N_each * (pattern + 1) ) &&
                            (i >= nVisible_each * pattern && i < nVisible_each * (pattern + 1)) ) {
                        train_X[n_][i] = RandomGenerator.binomial(1, 1-pNoise_Training, rng);
                    } else {
                        train_X[n_][i] = RandomGenerator.binomial(1, pNoise_Training, rng);
                    }
                }
            }
            for (int n = 0; n < test_N_each; n++) {
                int n_ = pattern * test_N_each + n;
                for (int i = 0; i < nVisible; i++) {
                    if ( (n_ >= test_N_each * pattern && n_ < test_N_each * (pattern + 1) ) &&
                            (i >= nVisible_each * pattern && i < nVisible_each * (pattern + 1)) ) {
                        test_X[n_][i] = RandomGenerator.binomial(1, 1-pNoise_Test, rng);
                    } else {
                        test_X[n_][i] = RandomGenerator.binomial(1, pNoise_Test, rng);
                    }
                }
            }
        }
        // ミニバッチの作成
        for (int i = 0; i < minibatch_N; i++) {
            for (int j = 0; j < minibatchSize; j++) {
                train_X_minibatch[i][j] = train_X[minibatchIndex.get(i * minibatchSize + j)];
            }
        }
    }
    /**
     * RestrictedBoltzmannMachinesModelの構築
     */
    public void buildBoltzmannMachinesModel(){
        // RBMインスタンス生成
    	// nVisible
    	// nHidden
    	// null 重み行列W
    	// null 隠れ層のバイアス hbias
    	// null 可視層のバイアス vbias
    	// rng  random
        RestrictedBoltzmannMachines nn = new RestrictedBoltzmannMachines(nVisible, nHidden, null, null, null, rng);
        //ミニバッチごとに1階のサンプリングを行うコントラスティブダイバージェンスCD-1が適用
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int batch = 0; batch < minibatch_N; batch++) {
                nn.contrastiveDivergence(train_X_minibatch[batch], minibatchSize, learningRate, 1);
            }
            learningRate *= 0.995;
        }
        // テスト（ノイズデータの再構築）
        for (int i = 0; i < test_N; i++) {
            reconstructed_X[i] = nn.reconstruct(test_X[i]);
        }
    }
    /**
     * RBMモデルの再構築評価と出力
     */
    public void evaluate(){
        // evaluation
        System.out.println("---------------------");
        System.out.println("RBMモデルの再構築評価");
        System.out.println("---------------------");
        for (int pattern = 0; pattern < patterns; pattern++) {
            System.out.printf("クラス%d\n", pattern + 1);
            for (int n = 0; n < test_N_each; n++) {
                int n_ = pattern * test_N_each + n;
                System.out.print( Arrays.toString(test_X[n_]) + " -> ");
                System.out.print("[");
                for (int i = 0; i < nVisible-1; i++) {
                    System.out.printf("%.5f, ", reconstructed_X[n_][i]);
                }
                System.out.printf("%.5f]\n", reconstructed_X[n_][nVisible-1]);
            }
            System.out.println();
        }

    }
}

/**
 * 多層パーセプトロン（多層ニューラルネットワーク）
 * 単層ニューラルネットワークには大きな問題があった。
 * 線形分離できる問題には効率的なパーセプトロンやロジスティック回帰であるが、
 * 非線形問題を全く解くことができないのである。
 * 最も単純なXOR（排他的論理和問題）でさえとくことができない。
 * 現実問題のほとんどは非線形であるため、パーセプトロンやロジスティック回帰
 * では実用性がない。
 * そこで非線形の問題にも対応できるようにアルゴリズムを改良したものが、
 * 多層ニューラスネットワークである。
 * 入力層と出力層の間に「隠れ層」と呼ばれる層を加えることで、
 * ネットワークが様々なパターンを表現できるようにした。
 * 個々で重要なのは、隠れ層を飛び越えた入力層と出力層の直結を導入せず、
 * 必ず、フィードフォワードネットワークの構造にしておくこと。
 * こうすることで、隠れ層の数が多くなろうとも、数学的に複雑になりすぎずに、
 * 任意の関数を近似することができる。
 * 隠れ層にはHiddenLayerクラス、出力層にはLogisticRegressionクラスが定義されている。
 * 出力の誤差をネットワーク全体に逆伝播することにより、各反復でモデルがトレー
 * ニングデータに適合するよう更新されるバックプロパゲーションが鍵となる。
 */
class MultiLayerPerceptrons {
    private HiddenLayer hiddenLayer;
    private LogisticRegression logisticLayer;
    private Random rng ;
    private int patterns;
    private int train_N;
    private int test_N;
    private int nIn;
    private int nHidden;
    private int nOut;
    private double[][] train_X;
    private int[][] train_T;
    private double[][] test_X;
    private Integer[][] test_T;
    private Integer[][] predicted_T = new Integer[test_N][nOut];
    private int epochs;
    private double learningRate;
    private int minibatchSize;  //  here, we do on-line training
    private int minibatch_N ;
    private double[][][] train_X_minibatch ;
    private int[][][] train_T_minibatch;
    private List<Integer> minibatchIndex;
    private double accuracy ;
    private double[] precision;
    private double[] recall;
    public MultiLayerPerceptrons(int nIn, int nHidden, int nOut, Random rng) {
        this.nIn = nIn;
        this.nHidden = nHidden;
        this.nOut = nOut;
        if (rng == null) rng = new Random(1234);
        this.rng = rng;

        // tanh関数を活性化関数とする隠れ層を定義：sigmoidまたはtanh
        hiddenLayer = new HiddenLayer(nIn, nHidden, null, null, rng, "tanh");  // sigmoid または tanh
        // 多クラスロジスティック回帰が活性化関数である出力層を定義
        logisticLayer = new LogisticRegression(nHidden, nOut);

        patterns = 2;
        train_N = 4;
        test_N = 4;
        nIn = 2;
        nHidden = 3;
        nOut = patterns;
        predicted_T = new Integer[test_N][nOut];
        epochs = 5000;
        learningRate = 0.1;
        minibatchSize = 1;  //  here, we do on-line training
        minibatch_N = train_N / minibatchSize;
        train_X_minibatch = new double[minibatch_N][minibatchSize][nIn];
        train_T_minibatch = new int[minibatch_N][minibatchSize][nOut];
        minibatchIndex = new ArrayList<>();
        for (int i = 0; i < train_N; i++) minibatchIndex.add(i);
        Collections.shuffle(minibatchIndex, rng);
        accuracy = 0.;
        precision = new double[patterns];
        recall = new double[patterns];
    }
    /**
     * 
     */
	// Training simple XOR problem for demo
	//   class 1 : [0, 0], [1, 1]  ->  Negative [0, 1]
	//   class 2 : [0, 1], [1, 0]  ->  Positive [1, 0]
    public void setDataSet(){
        train_X = new double[][]{
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.}
        };
        train_T = new int[][]{
                {0, 1},
                {1, 0},
                {1, 0},
                {0, 1}
        };
        test_X = new double[][]{
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.}
        };
        test_T = new Integer[][]{
                {0, 1},
                {1, 0},
                {1, 0},
                {0, 1}
        };
        // ミニバッチの作成
        for (int i = 0; i < minibatch_N; i++) {
            for (int j = 0; j < minibatchSize; j++) {
                train_X_minibatch[i][j] = train_X[minibatchIndex.get(i * minibatchSize + j)];
                train_T_minibatch[i][j] = train_T[minibatchIndex.get(i * minibatchSize + j)];
            }
        }
    	
    }
    /**
     * マルチレイヤーパーセプトロンモデルの構築
     */
    public void buildMultiLayerPerceptronsModel(){
        // construct
        MultiLayerPerceptrons classifier = new MultiLayerPerceptrons(nIn, nHidden, nOut, rng);
        // train
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int batch = 0; batch < minibatch_N; batch++) {
                classifier.train(train_X_minibatch[batch], train_T_minibatch[batch], minibatchSize, learningRate);
            }
        }
        // test
        for (int i = 0; i < test_N; i++) {
            predicted_T[i] = classifier.predict(test_X[i]);
        }
    }
    public void evaluate(){
        int[][] confusionMatrix = new int[patterns][patterns];

        for (int i = 0; i < test_N; i++) {
            int predicted_ = Arrays.asList(predicted_T[i]).indexOf(1);
            int actual_ = Arrays.asList(test_T[i]).indexOf(1);

            confusionMatrix[actual_][predicted_] += 1;
        }
        for (int i = 0; i < patterns; i++) {
            double col_ = 0.;
            double row_ = 0.;
            for (int j = 0; j < patterns; j++) {
                if (i == j) {
                    accuracy += confusionMatrix[i][j];
                    precision[i] += confusionMatrix[j][i];
                    recall[i] += confusionMatrix[i][j];
                }
                col_ += confusionMatrix[j][i];
                row_ += confusionMatrix[i][j];
            }
            precision[i] /= col_;
            recall[i] /= row_;
        }
        accuracy /= test_N;
    }
    public void print(){
        System.out.println("----------------------------------------");
        System.out.println("マルチレイヤーパーセプトロンモデルの評価");
        System.out.println("----------------------------------------");
        System.out.printf("正解率: %.1f %%\n", accuracy * 100);
        System.out.println("精　度:");
        for (int i = 0; i < patterns; i++) {
            System.out.printf(" クラス %d: %.1f %%\n", i+1, precision[i] * 100);
        }
        System.out.println("再現率:");
        for (int i = 0; i < patterns; i++) {
            System.out.printf(" クラス %d: %.1f %%\n", i+1, recall[i] * 100);
        }
    }
    public void train(double[][] X, int T[][], int minibatchSize, double learningRate) {
        double[][] Z = new double[minibatchSize][nIn];  // 隠れ層の出力（出力層への入力）
        double[][] dY;
        // 隠れ層から順伝播
        for (int n = 0; n < minibatchSize; n++) {
            Z[n] = hiddenLayer.forward(X[n]);  // 入力ユニットを活性化
        }
        // 出力層から順伝播及び逆伝播
        dY = logisticLayer.train(Z, T, minibatchSize, learningRate);
        // 隠れ層から逆伝播
        // ロジスティック回帰による予測誤差dYをバックプロパゲーションする。
        // ロジスティック回帰の入力値はバックプロパゲーションにも必要
        hiddenLayer.backward(X, Z, dY, logisticLayer.W, minibatchSize, learningRate);
    }
    public Integer[] predict(double[] x) {
        double[] z = hiddenLayer.output(x);
        return logisticLayer.predict(z);
    }
}

/**
 * 多クラスロジスティック回帰 ソフトマックス関数
 * ロジスティック回帰は多クラス分類にも応用することができる。
 * 2クラス分類では、活性化関数がシグモイド関数であり、出力が０から１になる
 * ことで、データがどちらのクラスに所属する確率が高いかを求めることができた。
 * クラス数がＫのときは、各クラスの所属度を表す確立ベクトル（出力がＫ次元）と 
 * することで多クラスデータも分類できる。
 * シグモイド関数の多変量版であるソフトマックス関数を用いる。
 */
class LogisticRegressionXOR {
	Random rng; // ランダム関数
	double[][] W;
	double[] b;
	int patterns; // クラスの数
	int train_N;
	int test_N;
	int nIn ;
	int nOut;
	double[][] train_X;
	int[][] train_T;
	double[][] test_X;
	Integer[][] test_T;
	Integer[][] predicted_T;
	int epochs;
	double learningRate ;
	int minibatchSize ; // set 1 for on-line training
	int minibatch_N ;
	double[][][] train_X_minibatch ;
	int[][][] train_T_minibatch ;
	List<Integer> minibatchIndex;
	public LogisticRegressionXOR(int nIn, int nOut) {
		Random rng = new Random(1234); // ランダム関数
		patterns = 2; // クラスの数
		train_N = 4;
		test_N = 4;
		nIn = 2;
		nOut = patterns;
		this.nIn = nIn;
		this.nOut = nOut;
		W = new double[nOut][nIn];//ネットワークの重み
		b = new double[nOut]; //バイヤス
		predicted_T = new Integer[test_N][nOut];
		epochs = 2000;
		learningRate = 0.2;
		minibatchSize = 1; // 各ミニバッチに含まれるデータ数
		minibatch_N = train_N / minibatchSize;
		train_X_minibatch = new double[minibatch_N][minibatchSize][nIn];
		train_T_minibatch = new int[minibatch_N][minibatchSize][nOut];
		// 各ミニバッチのデータが確率的勾配降下法(SGD)にランダムに適用されるよう
		// トレーニングデータをシャッフル
		minibatchIndex = new ArrayList<>();
		for (int i = 0; i < train_N; i++){
			minibatchIndex.add(i);
		}
		Collections.shuffle(minibatchIndex, rng);
	}
	/**
	 * トレーニングデータの作成
	 * ここでは多クラス分類問題を扱いたいため3クラスに分かれたサンプルデータセットを生成
	 * パーセプトロンで用いたクラス1、クラス2の平均・分散の組み合わせに加え、
	 * クラス3のデータとして、平均０．０、分散１．０の正規分布に従ったデータを生成する。
	 * 
	 */
	// クラス 1 : [0, 0], [1, 1] ネガティブクラス
	// クラス 2 : [0, 1], [1, 0] ポジティブクラス
	public void setDataSet(){
        train_X = new double[][]{
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.}
        };
        train_T = new int[][]{
                {0, 1},
                {1, 0},
                {1, 0},
                {0, 1}
        };
        test_X = new double[][]{
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.}
        };
        test_T = new Integer[][]{
                {0, 1},
                {1, 0},
                {1, 0},
                {0, 1}
        };
		//　トレーニングデータをミニバッチにかける
        //
		for (int i = 0; i < minibatch_N; i++) {
			for (int j = 0; j < minibatchSize; j++) {
				train_X_minibatch[i][j] = train_X[minibatchIndex.get(i * minibatchSize + j)];
				train_T_minibatch[i][j] = train_T[minibatchIndex.get(i * minibatchSize + j)];
			}
		}
	}
	/**
	 * ロジスティック回帰モデルの構築 
	 */
	public void buildLogisticRegressionModel(){
		// 学習はミニバッチごとに行われる。
		// minibatchSize=1と設定した場合は、
		// データセットからランダムに１データずつ選び出して学習するオンライン学習。
		LogisticRegression classifier = new LogisticRegression(nIn, nOut);
		for (int epoch = 0; epoch < epochs; epoch++) {
			for (int batch = 0; batch < minibatch_N; batch++) {
				classifier.train(train_X_minibatch[batch], train_T_minibatch[batch], minibatchSize, learningRate);
			}
			learningRate *= 0.95; //モデルが収束されるよう学習率は徐々に減少
		}
		// テスト
		for (int i = 0; i < test_N; i++) {
			predicted_T[i] = classifier.predict(test_X[i]);
		}
	}
	/**
	 *  出力
	 */
	public void print(){
		// 出力
		for (int i = 0; i < test_N; i++) {
			System.out.print("[" + test_X[i][0] + ", " + test_X[i][1] + "] -> 予測: ");
			if (predicted_T[i][0] > predicted_T[i][1]) {
				System.out.print("ポジティブ, ");
				System.out.print("確率=" + predicted_T[i][0]);
			} else {
				System.out.print("ネガティブ, ");
				System.out.print("確率=" + predicted_T[i][1]);
			}
			System.out.print("; 実際: ");
			if (test_T[i][0] == 1) {
				System.out.println("ポジティブ");
			} else {
				System.out.println("ネガティブ");
			}
		}
	}
}
/**
 * ロジスティック回帰 シグモイド関数
 * 連続値を取る二つの変数からなる式を想定した回帰モデルで、
 * パーセプトロンを一般化した線形分離モデルで、ニューラルネットワーク の一
 * つである。
 * パーセプトロンでは、活性化関数にステップ関数を用いているが、 ロジスティッ
 * ク回帰では、シグモイド関数を用いている。
	 * シグモイド関数は、任意の実数を０から１の値に写像する。
 * つまりロジ スティック回帰の出力は、それぞれのクラスの事後確率と見なすこ
 * とができる。
 */
class LogisticRegression {
	double[][] W;
	double[] b;
	Random rng; // ランダム関数
	int patterns; // クラスの数
	int train_N;
	int test_N;
	int nIn;
	int nOut;
	double[][] train_X;
	int[][] train_T;
	double[][] test_X;
	Integer[][] test_T;
	Integer[][] predicted_T;
	int epochs;
	double learningRate;
	int minibatchSize; // 各ミニバッチに含まれるデータ数
	int minibatch_N; // ミニバッチ数
	double[][][] train_X_minibatch; // 入力データであるトレーニングデータのミニバッチ
	int[][][] train_T_minibatch; // 出力データであるトレーニングデータのミニバッチ
	List<Integer> minibatchIndex; // SDGが適用されるミニバッチのインデックス（順番）
	double accuracy;
	double[] precision;
	double[] recall;
	public LogisticRegression(int nIn, int nOut) {
		rng = new Random(1234); // ランダム関数
		this.nIn = nIn;
		this.nOut = nOut;
		W = new double[nOut][nIn];
		b = new double[nOut];
		nIn = 2;
		patterns = 3; // クラスの数
		nOut = patterns;
		train_N = 400 * patterns;
		test_N = 60 * patterns;
		train_X = new double[train_N][nIn];
		train_T = new int[train_N][nOut];
		test_X = new double[test_N][nIn];
		test_T = new Integer[test_N][nOut];
		predicted_T = new Integer[test_N][nOut];
		epochs = 2000;
		learningRate = 0.2;
		minibatchSize = 50; // 各ミニバッチに含まれるデータ数
		minibatch_N = train_N / minibatchSize; // ミニバッチ数
		train_X_minibatch = new double[minibatch_N][minibatchSize][nIn]; // 入力データであるトレーニングデータのミニバッチ
		train_T_minibatch = new int[minibatch_N][minibatchSize][nOut]; // 出力データであるトレーニングデータのミニバッチ
		minibatchIndex = new ArrayList<>(); // SDGが適用されるミニバッチのインデックス（順番）
		for (int i = 0; i < train_N; i++)
			minibatchIndex.add(i);
		Collections.shuffle(minibatchIndex, rng); // SDGを適用する順番をランダム化
		accuracy = 0.;
		precision = new double[patterns];
		recall = new double[patterns];
	}
	/**
	 * データセットのセット
	 */
	// Training data for demo
	// class 1 : x1 ~ N( -2.0, 1.0 ), y1 ~ N( +2.0, 1.0 )
	// class 2 : x2 ~ N( +2.0, 1.0 ), y2 ~ N( -2.0, 1.0 )
	// class 3 : x3 ~ N( 0.0, 1.0 ), y3 ~ N( 0.0, 1.0 )
	public void setDataSet() {
		GaussianDistribution g1 = new GaussianDistribution(-2.0, 1.0, rng);
		GaussianDistribution g2 = new GaussianDistribution(2.0, 1.0, rng);
		GaussianDistribution g3 = new GaussianDistribution(0.0, 1.0, rng);
		// クラス1のデータセット
		for (int i = 0; i < train_N / patterns - 1; i++) {
			train_X[i][0] = g1.random();
			train_X[i][1] = g2.random();
			train_T[i] = new int[] { 1, 0, 0 };
		}
		for (int i = 0; i < test_N / patterns - 1; i++) {
			test_X[i][0] = g1.random();
			test_X[i][1] = g2.random();
			test_T[i] = new Integer[] { 1, 0, 0 };
		}
		// クラス2のデータセット
		for (int i = train_N / patterns - 1; i < train_N / patterns * 2 - 1; i++) {
			train_X[i][0] = g2.random();
			train_X[i][1] = g1.random();
			train_T[i] = new int[] { 0, 1, 0 };
		}
		for (int i = test_N / patterns - 1; i < test_N / patterns * 2 - 1; i++) {
			test_X[i][0] = g2.random();
			test_X[i][1] = g1.random();
			test_T[i] = new Integer[] { 0, 1, 0 };
		}
		// クラス3のデータセット
		for (int i = train_N / patterns * 2 - 1; i < train_N; i++) {
			train_X[i][0] = g3.random();
			train_X[i][1] = g3.random();
			train_T[i] = new int[] { 0, 0, 1 };
		}
		for (int i = test_N / patterns * 2 - 1; i < test_N; i++) {
			test_X[i][0] = g3.random();
			test_X[i][1] = g3.random();
			test_T[i] = new Integer[] { 0, 0, 1 };
		}
		/**
		 * データセットの中から部分的にいくつかのデータを選び取って、 
		 * それらのデータに対してだけ和を計算して勾配を求めパラメータを更新する。
		 * これを確率的勾配降下法という。 
		 * このとき1回の更新に用いられるデータセットの部分集合のことをミニバッチという。
		 */
		for (int i = 0; i < minibatch_N; i++) {
			for (int j = 0; j < minibatchSize; j++) {
				train_X_minibatch[i][j] = train_X[minibatchIndex.get(i * minibatchSize + j)];
				train_T_minibatch[i][j] = train_T[minibatchIndex.get(i * minibatchSize + j)];
			}
		}
	}
	/**
	 * ロジスティック回帰モデルの構築
	 */
	public void buildLogisticRegressionModel() {
		// 学習
		LogisticRegression classifier = new LogisticRegression(nIn, nOut);
		for (int epoch = 0; epoch < epochs; epoch++) {
			for (int batch = 0; batch < minibatch_N; batch++) {
				classifier.train(train_X_minibatch[batch], train_T_minibatch[batch], minibatchSize, learningRate);
			}
			learningRate *= 0.95;
		}
		// テスト
		for (int i = 0; i < test_N; i++) {
			predicted_T[i] = classifier.predict(test_X[i]);
		}
	}
	/**
	 * 評価モデル
	 */
	public void evaluate() {
		int[][] confusionMatrix = new int[patterns][patterns];
		for (int i = 0; i < test_N; i++) {
			int predicted_ = Arrays.asList(predicted_T[i]).indexOf(1);
			int actual_ = Arrays.asList(test_T[i]).indexOf(1);
			confusionMatrix[actual_][predicted_] += 1;
		}
		for (int i = 0; i < patterns; i++) {
			double col_ = 0.;
			double row_ = 0.;
			for (int j = 0; j < patterns; j++) {
				if (i == j) {
					accuracy += confusionMatrix[i][j];
					precision[i] += confusionMatrix[j][i];
					recall[i] += confusionMatrix[i][j];
				}
				col_ += confusionMatrix[j][i];
				row_ += confusionMatrix[i][j];
			}
			precision[i] /= col_;
			recall[i] /= row_;
		}
		accuracy /= test_N;
	}
	/**
	 * 出力
	 */
	public void print() {
		System.out.println("------------------------------");
		System.out.println("ロジスティック回帰モデルの評価");
		System.out.println("------------------------------");
		System.out.printf("正解率: %.1f %%\n", accuracy * 100);
		System.out.println("精　度:");
		for (int i = 0; i < patterns; i++) {
			System.out.printf(" クラス %d: %.1f %%\n", i + 1, precision[i] * 100);
		}
		System.out.println("再現率:");
		for (int i = 0; i < patterns; i++) {
			System.out.printf(" クラス %d: %.1f %%\n", i + 1, recall[i] * 100);
		}
	}
	/**
	 * 学習
	 */
	public double[][] train(double[][] X, int T[][], int minibatchSize, double learningRate) {
		double[][] grad_W = new double[nOut][nIn];
		double[] grad_b = new double[nOut];
		double[][] dY = new double[minibatchSize][nOut];
		// SGD で学習
		// 1. 重みＷとバイアスｂの勾配を計算
		for (int n = 0; n < minibatchSize; n++) {
			double[] predicted_Y_ = output(X[n]);
			for (int j = 0; j < nOut; j++) {
				dY[n][j] = predicted_Y_[j] - T[n][j];
				for (int i = 0; i < nIn; i++) {
					grad_W[j][i] += dY[n][j] * X[n][i];
				}
				grad_b[j] += dY[n][j];
			}
		}
		// 2. パラメータを更新する
		for (int j = 0; j < nOut; j++) {
			for (int i = 0; i < nIn; i++) {
				W[j][i] -= learningRate * grad_W[j][i] / minibatchSize;
			}
			b[j] -= learningRate * grad_b[j] / minibatchSize;
		}
		return dY; //予測データと正しいデータとの誤差が返される
	}
	public double[] output(double[] x) {
		double[] preActivation = new double[nOut];
		for (int j = 0; j < nOut; j++) {
			for (int i = 0; i < nIn; i++) {
				preActivation[j] += W[j][i] * x[i];
			}
			preActivation[j] += b[j]; // 線形活性化にも対応させている
		}
		// ソフトマックス関数は各クラスの確率を示す配列を返し、インデックスが予測クラスを表している
		return ActivationFunction.softmax(preActivation, nOut);
	}
	//予測メソッド
	// 学習されたモデルを使って入力データを予測する
	public Integer[] predict(double[] x) {
		double[] y = output(x); // 入力データを学習済みモデルによって活性化し出力層へ
		Integer[] t = new Integer[nOut]; // 出力は確立で表されているためラベル（分類されたクラス）に変換
//		System.out.println(Arrays.toString(y));
		int argmax = -1;
		double max = 0.;
		for (int i = 0; i < nOut; i++) {
			if (max < y[i]) {
				max = y[i];
				argmax = i;
			}
		}
		for (int i = 0; i < nOut; i++) {
			if (i == argmax) {
				t[i] = 1;
			} else {
				t[i] = 0;
			}
		}
		return t;
	}
}
/**
 * パーセプトロン ステップ関数 
 * パーセプトロンは、ニューラルネットワークのアルゴリズムの中でも
 * 最も単純な作りをしたモデルであり、二つのクラスを線形識別できる 
 * モデルでニューラルネットワークの原型でもある。
 * データセットが線形に分けられることが保証されている場合、アルゴリズムの精
 * 度は学習率の値とは無関係であるため、学習率の値は１でよい。
 */
class Perceptrons {
	private int nIn;            // 入力層のユニット数(ニューロン数）
	private double[] w;         // ネットワークの重み
	private final Random rng;
	private final int train_N;  // トレーニングデータ数
	private final int test_N;   // テストデータ数
	private double[][] train_X; // トレーニングデータ
	private int[] train_T;      // トレーニングデータのラベル
	private double[][] test_X;  // テストデータ
	private int[] test_T;       // テストデータのラベル
	private final double learningRate; // 学習率
	/**
	 * コンストラクタ
   * nInが入力層のユニット数
	 */
	public Perceptrons(int nIn) {
		this.nIn = nIn;           // 入力層のユニット数（ニューロン数）
		w = new double[nIn];      // ネットワークの重み
		rng = new Random(1234);
		train_N = 1000;           // トレーニングデータ数
		test_N = 200;             // テストデータ数
		train_X = new double[train_N][nIn]; // トレーニングデータ
		train_T = new int[train_N]; // トレーニングデータのラベル
		test_X = new double[test_N][nIn]; // テストデータ
		test_T = new int[test_N]; // テストデータのラベル
		learningRate = 1.;        // 学習率はパーセプトロンでは１でよい
	}
	/**
   * デモのためのトレーニングデータとテストデータの作成 正規分布（ガウス分布）
   * に従った値を返すGaussianDistributionクラスを定義
   *
	 * トレーニングデータの次元はnIn=2に 
   * class 1 : x1 ~ N( -2.0, 1.0 ), y1 ~ N( +2.0, 1.0 )
	 * class 2 : x2 ~ N( +2.0, 1.0 ), y2 ~ N( -2.0, 1.0 )
   *
   * 直線的に分離することが可能だが、一部のデータはノイズとして他クラス の近く
   * に混ざってしまうことがある
	 */
	public void setDataSet() {
		GaussianDistribution g1 = new GaussianDistribution(-2.0, 1.0, rng);// 平均-2.0  分散1.0
		GaussianDistribution g2 = new GaussianDistribution(2.0, 1.0, rng);// 平均2.0 分散1.0
		// クラス1のデータセット [ -2.0, 2,0]に分布する
		for (int i = 0; i < train_N / 2 - 1; i++) {
			train_X[i][0] = g1.random();
			train_X[i][1] = g2.random();
			train_T[i] = 1; // 1
		}
		for (int i = 0; i < test_N / 2 - 1; i++) {
			test_X[i][0] = g1.random();
			test_X[i][1] = g2.random();
			test_T[i] = 1; // 1
		}
		// クラス2のデータセット [ 2.0, -2,0]に分布する
		for (int i = train_N / 2; i < train_N; i++) {
			train_X[i][0] = g2.random();
			train_X[i][1] = g1.random();
			train_T[i] = -1; // -1
		}
		for (int i = test_N / 2; i < test_N; i++) {
			test_X[i][0] = g2.random();
			test_X[i][1] = g1.random();
			test_T[i] = -1; // -1
		}
	}
	/**
	 * モデルの構築
	 */
	public void buildModel() {
		int epochs = 2000; // トレーニング数の上限
		int epoch = 0; // training epochs
		// 学習の反復解数は、あらかじめ設定された十分な学習解数にとうたつ
		// するまで、もしくはトレーニングデータを正しく分類するまで
		// 継続されるようにする
		while (true) { // 学習
			int classified_ = 0;
			for (int i = 0; i < train_N; i++) {
				// 学習 trainメソッドでは勾配降下アルゴリズムを用いることができる
				classified_ += train(train_X[i], train_T[i], learningRate);
			}
			if (classified_ == train_N) { // 全データが正しく分類されていたら
				break; // 学習をストップ
			}
			epoch++;
			if (epoch > epochs) {
				break;
			}
		}
	}
	/**
	 * 学習メソッド trainメソッド
   * 勾配降下アルゴリズムを用いることができる
	 */
	public int train(double[] x, int t, double learningRate) {
		int classified = 0;
		double c = 0.;
		// データが正しく分類されているかチェック
		for (int i = 0; i < nIn; i++) {
			c += w[i] * x[i] * t; // ネットワークパラメータが更新
		}
		// データが間違って分類されている場合、勾配降下法を適用する
		if (c > 0) {
			classified = 1;
		} else { // 誤分類されていたら
			for (int i = 0; i < nIn; i++) {
				w[i] += learningRate * x[i] * t; // ネットワークパラメータが更新
			}
		}
		return classified;
	}
	/**
	 * 評価テスト  混合行列(confutonMatrix)をもとに、モデルの評価
   *
	 * 正解率(accuracy) 全データの中で正しく分類できたデータの割合
	 * (TruePositive+TrueNegative) / * (TruePositive+TrueNegative+FalsePositive+FalseNegative)
   * 
	 * 精度(precision) Positiveと予測したデータの中からPositiveと予測できたデータの割合
	 * TruePositive / TruePositive + FalsePositive
   *
	 * 再現率(recall)
	 * TruePositive / (TruePositife + falseNegative)
	 */
	public void evaluetion() {
		double accuracy = 0.;
		double precision = 0.;
		double recall = 0.;
		int[][] confusionMatrix = new int[2][2];
		int[] predicted_T = new int[test_N]; // モデルの予想結果
    // テスト
		for (int i = 0; i < test_N; i++) {
			// テストデータの分類結果を配列に格納
			predicted_T[i] = predict(test_X[i]);
		}
		for (int i = 0; i < test_N; i++) {
			if (predicted_T[i] > 0) {
				if (test_T[i] > 0) {
					accuracy += 1;
					precision += 1;
					recall += 1;
					confusionMatrix[0][0] += 1;
				} else {
					confusionMatrix[1][0] += 1;
				}
			} else {
				if (test_T[i] > 0) {
					confusionMatrix[0][1] += 1;
				} else {
					accuracy += 1;
					confusionMatrix[1][1] += 1;
				}
			}
		}
		//出力
		print(confusionMatrix, accuracy, precision, recall);
	}
	/**
	 * ネットワークを通じて入力を活性化
	 */
	public int predict(double[] x) {
		double preActivation = 0.;
		for (int i = 0; i < nIn; i++) {
			preActivation += w[i] * x[i];
		}
		return ActivationFunction.step(preActivation);
	}
	/**
	 * 出力 Positiveであるデータはすべて正しく分類することができたが、
	 * 誤って実際はnegativeであるデータをpositiveと予測してしまったデータ がある、という事を意味している。
	 */
	public void print(int[][] confusionMatrix, double accuracy, double precision, double recall) {
		accuracy /= test_N;
		precision /= confusionMatrix[0][0] + confusionMatrix[1][0];
		recall /= confusionMatrix[0][0] + confusionMatrix[0][1];
		System.out.println("--------------------------");
		System.out.println("パーセプトロンモデルの評価");
		System.out.println("--------------------------");
		System.out.printf("正解率:  %.1f %%\n", accuracy * 100);
		System.out.printf("精　度:  %.1f %%\n", precision * 100);
		System.out.printf("再現率:  %.1f %%\n", recall * 100);
	}
}
final class GaussianDistribution {
	private final double mean;
	private final double var;
	private final Random rng;
	public GaussianDistribution(double mean, double var, Random rng) {
		if (var < 0.0) {
			throw new IllegalArgumentException("Variance must be non-negative value.");
		}
		this.mean = mean;
		this.var = var;
		if (rng == null) {
			rng = new Random();
		}
		this.rng = rng;
	}
	public double random() {
		double r = 0.0;
		while (r == 0.0) {
			r = rng.nextDouble();
		}
		double c = Math.sqrt(-2.0 * Math.log(r));
		if (rng.nextDouble() < 0.5) {
			return c * Math.sin(2.0 * Math.PI * rng.nextDouble()) * var + mean;
		}
		return c * Math.cos(2.0 * Math.PI * rng.nextDouble()) * var + mean;
	}
}
/*
 * シグモイド関数の導関数及びハイパボリックタンジェント(tanh)関数
 * シグモイド関数の代わりに良く使われる活性化関数
 */
final class ActivationFunction {
	public static int step(double x) {
		if (x >= 0) {
			return 1;
		} else {
			return -1;
		}
	}
	public static double sigmoid(double x) {
		return 1. / (1. + Math.pow(Math.E, -x));
	}
	public static double dsigmoid(double y) {
		return y * (1. - y);
	}
	public static double tanh(double x) {
		return Math.tanh(x);
	}
	public static double dtanh(double y) {
		return 1. - y * y;
	}
	public static double ReLU(double x) {
		if (x > 0) {
			return x;
		} else {
			return 0.;
		}
	}
	public static double dReLU(double y) {
		if (y > 0) {
			return 1.;
		} else {
			return 0.;
		}
	}
	public static double[] softmax(double[] x, int n) {
		double[] y = new double[n];
		double max = 0.;
		double sum = 0.;
		for (int i = 0; i < n; i++) {
			if (max < x[i]) {
				max = x[i]; // オーバーフローを防止
			}
		}
		for (int i = 0; i < n; i++) {
			y[i] = Math.exp(x[i] - max);
			sum += y[i];
		}
		for (int i = 0; i < n; i++) {
			y[i] /= sum;
		}
		return y;
	}
}
/**
 * バックプロパゲーション部分
 * 多層ニューラルネットワークでは、ニューラルネットワークを通じて、
 * フォワードプロパゲーション（順伝播）、バックプロパゲーション（逆伝播）が交互に行われることで
 * 学習が進む。
 */
class HiddenLayer {
    public int nIn;
    public int nOut;
    public double[][] W;
    public double[] b;
    public Random rng;
    public DoubleFunction<Double> activation;
    public DoubleFunction<Double> dactivation;
    public HiddenLayer(int nIn, int nOut, double[][] W, double[] b, Random rng, String activation) {
        if (rng == null) rng = new Random(1234);  // 乱数シード
        if (W == null) { // 重み W 
            W = new double[nOut][nIn];
            double w_ = 1. / nIn;

            for(int j = 0; j < nOut; j++) {
                for(int i = 0; i < nIn; i++) {
                	// 重みW は一様分布を用いて初期化
                	// Wは各層のユニット数と合致する次元でランダムに初期化
                    W[j][i] = RandomGenerator.uniform(-w_, w_, rng);  
                }
            }
        }
        if (b == null) b = new double[nOut];
        this.nIn = nIn;
        this.nOut = nOut;
        this.W = W;
        this.b = b;
        this.rng = rng;
        if (activation == "sigmoid" || activation == null) {
            this.activation = (double x) -> ActivationFunction.sigmoid(x);
            this.dactivation = (double x) -> ActivationFunction.dsigmoid(x);
        } else if (activation == "tanh") {
            this.activation = (double x) -> ActivationFunction.tanh(x);
            this.dactivation = (double x) -> ActivationFunction.dtanh(x);
        } else if (activation == "ReLU") {
            this.activation = (double x) -> ActivationFunction.ReLU(x);
            this.dactivation = (double x) -> ActivationFunction.dReLU(x);
        } else {
            throw new IllegalArgumentException("activation function not supported");
        }
    }

    public double[] output(double[] x) {
        double[] y = new double[nOut];
        for (int j = 0; j < nOut; j++) {
            double preActivation_ = 0.;
            for (int i = 0; i < nIn; i++) {
                preActivation_ += W[j][i] * x[i];
            }
            preActivation_ += b[j];
            y[j] = activation.apply(preActivation_);
        }
        return y;
    }

    public int[] outputBinomial(int[] x, Random rng) {
        int[] y = new int[nOut];
        double[] xCast = new double[x.length];
        for (int i = 0; i < xCast.length; i++) {
            xCast[i] = (double) x[i];
        }
        double[] out = output(xCast);
        for (int j = 0; j < nOut; j++) {
            y[j] = RandomGenerator.binomial(1, out[j], rng);
        }
        return y;
    }

    public double[] forward(double[] x) {
        return output(x);
    }

    /**
     * ミニバッチを使ってWとbの勾配を計算し、モデルパラメータを更新する。 
     */
    public double[][] backward(double[][] X, double[][] Z, double[][] dY, double[][] Wprev, int minibatchSize, double learningRate) {
        double[][] dZ = new double[minibatchSize][nOut];  // 逆伝播誤差
        double[][] grad_W = new double[nOut][nIn];
        double[] grad_b = new double[nOut];
        // SDGを用いて学習
        // まず誤差を求め、誤差を用いてパラメータW,bの勾配を求める
        for (int n = 0; n < minibatchSize; n++) {
            for (int j = 0; j < nOut; j++) {
                for (int k = 0; k < dY[0].length; k++) {  // k<( 前層のnOut)
                    dZ[n][j] += Wprev[k][j] * dY[n][k];
                }
                dZ[n][j] *= dactivation.apply(Z[n][j]);
                for (int i = 0; i < nIn; i++) {
                    grad_W[j][i] += dZ[n][j] * X[n][i];
                }
                grad_b[j] += dZ[n][j];
            }
        }
        // パラメータ更新
        for (int j = 0; j < nOut; j++) {
            for(int i = 0; i < nIn; i++) {
                W[j][i] -= learningRate * grad_W[j][i] / minibatchSize;
            }
            b[j] -= learningRate * grad_b[j] / minibatchSize;
        }
        return dZ;
    }
}
/**
 * 一様分布の乱数を生成するメソッドを記述
 * 隠れ層の重さをランダムに初期化するためであるが、
 * 初期値によってはモデルが局所最適解に落ちてしまい、分類に失敗することもあるので注意。
 */
class RandomGenerator {
	public static double uniform(double min, double max, Random rng) {
		return rng.nextDouble() * (max - min) + min;
	}
	/*
     * binomialは二項分布（結果が二つに分かれる場合の確率分布）に基づいて０または１の値を返す
     * 		このメソッドを通して各ユニットの値はバイナリとなる
     */
	public static int binomial(int n, double p, Random rng) {
		if (p < 0 || p > 1)
			return 0;
		int c = 0;
		double r;
		for (int i = 0; i < n; i++) {
			r = rng.nextDouble();
			if (r < p)
				c++;
		}
		return c;
	}
}
