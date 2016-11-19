package conlang.compilers;

interface compiler {
    public boolean shouldCompile();

    public String compile();
}